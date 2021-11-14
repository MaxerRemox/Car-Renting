package pl.rekrutacyjne.rekrutacyjne.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import pl.rekrutacyjne.rekrutacyjne.entities.Cars;
import pl.rekrutacyjne.rekrutacyjne.entities.User;
import pl.rekrutacyjne.rekrutacyjne.repositories.CarsRepository;
import pl.rekrutacyjne.rekrutacyjne.repositories.UserRepository;
import pl.rekrutacyjne.rekrutacyjne.security.UserEntityDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final CarsRepository carsRepository;


    public String loggedUser() {
        UserEntityDetails details = (UserEntityDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = details.getUsername();
        return username;
    }

    public User add(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setRoles(Set.of("USER"));
        return repository.save(user);
    }

    public ModelAndView checkRole(String username) {
        ModelAndView modelAndView = new ModelAndView();
        if (repository.findByUsernameIgnoreCase(username).get().getRoles().contains("ADMIN")) {
            modelAndView.setViewName("adminPanel");
        } else {
            modelAndView.setViewName("userPanel");
        }
        return modelAndView;
    }

    public User user() {
        UserEntityDetails details = (UserEntityDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = details.getUsername();
        User user = new User();
        user.setId(repository.findByUsernameIgnoreCase(username).get().getId());
        user.setName(repository.findByUsernameIgnoreCase(username).get().getName());
        user.setSurName(repository.findByUsernameIgnoreCase(username).get().getSurName());
        user.setRoles(repository.findByUsernameIgnoreCase(username).get().getRoles());
        user.setActive(repository.findByUsernameIgnoreCase(username).get().isActive());
        return user;
    }

    public List<Cars> myCars() {
        List<Cars> myCars = new ArrayList<>();
        List<Cars> allCars = carsRepository.findAll();
        for (int i = 0; i < allCars.size(); i++) {
            if (allCars.get(i).getRentedBy() != null) {
                if (allCars.get(i).getRentedBy().getId() == repository.findByUsernameIgnoreCase(loggedUser()).get().getId()) {
                    myCars.add(allCars.get(i));
                }
            }
        }
        return myCars;
    }

}
