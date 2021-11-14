package pl.rekrutacyjne.rekrutacyjne.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.rekrutacyjne.rekrutacyjne.entities.Cars;
import pl.rekrutacyjne.rekrutacyjne.services.CarService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;


    @GetMapping("/list")
    public ModelAndView getCars(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listOfCars");
        model.addAttribute("list", carService.list());
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(Model model) {
        model.addAttribute("add", new Cars());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCar");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Cars car) {
        carService.add(car);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/successful");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam Long id) {
        carService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/successful");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam Long id, Model model) {
        model.addAttribute("car", carService.edit(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCar");
        return modelAndView;
    }

    @RequestMapping("/editsave")
    public ModelAndView editSave(Cars car) {
        carService.add(car);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cars/list");
        return modelAndView;
    }

    @RequestMapping("/rent")
    public ModelAndView rent(Model model) {
        model.addAttribute("cars", carService.notRented());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rentCar");
        return modelAndView;
    }

    @RequestMapping("/renting")
    public ModelAndView renting(@RequestParam Long id, Cars car) {
        carService.add(carService.rent(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/successful");
        return modelAndView;
    }

    @RequestMapping("/returncar")
    public ModelAndView returnCar(@RequestParam Long id) {
        carService.add(carService.returningCar(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/successful");
        return modelAndView;
    }

}
