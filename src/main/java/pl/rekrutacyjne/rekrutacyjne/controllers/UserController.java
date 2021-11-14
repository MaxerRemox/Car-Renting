package pl.rekrutacyjne.rekrutacyjne.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.rekrutacyjne.rekrutacyjne.entities.User;
import pl.rekrutacyjne.rekrutacyjne.services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @RequestMapping("/login")
    public ModelAndView login(Model model){
        model.addAttribute("username",userService.loggedUser());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPanel");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView modelAndView(Model model){
        model.addAttribute("user", new User());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerUser");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(User user){
        userService.add(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping("/successful")
    public ModelAndView successful(){
        return userService.checkRole(userService.loggedUser());
    }

    @RequestMapping("/mycars")
    public ModelAndView myCars(Model model){
        model.addAttribute("myCars", userService.myCars());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userCars");
        return modelAndView;
    }
}
