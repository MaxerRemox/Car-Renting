package pl.rekrutacyjne.rekrutacyjne.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import pl.rekrutacyjne.rekrutacyjne.entities.Cars;
import pl.rekrutacyjne.rekrutacyjne.repositories.CarsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarsRepository carsRepository;
    private final UserService userService;

    public List<Cars> list() {
        return carsRepository.findAll();
    }

    public Cars add(Cars car) {
        return carsRepository.save(car);
    }

    public void delete(Long id) {
        carsRepository.deleteById(id);
    }

    public Cars edit(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCar");
        Cars car = new Cars();
        car.setId(carsRepository.findById(id).get().getId());
        car.setBrand(carsRepository.findById(id).get().getBrand());
        car.setModel(carsRepository.findById(id).get().getModel());
        car.setColor(carsRepository.findById(id).get().getColor());
        car.setEngine(carsRepository.findById(id).get().getEngine());
        return car;
    }

    public Cars rent(Long id) {
        Cars car = new Cars();
        car.setId(carsRepository.findById(id).get().getId());
        car.setBrand(carsRepository.findById(id).get().getBrand());
        car.setModel(carsRepository.findById(id).get().getModel());
        car.setColor(carsRepository.findById(id).get().getColor());
        car.setEngine(carsRepository.findById(id).get().getEngine());
        car.setRentedBy(userService.user());
        return car;
    }

    public List<Cars> notRented() {
        List<Cars> all = carsRepository.findAll();
        List<Cars> notRented = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getRentedBy() == null) {
                notRented.add(all.get(i));
            }
        }
        return notRented;
    }

    public Cars returningCar(Long id) {
        Cars car = new Cars();
        car.setId(carsRepository.findById(id).get().getId());
        car.setBrand(carsRepository.findById(id).get().getBrand());
        car.setModel(carsRepository.findById(id).get().getModel());
        car.setColor(carsRepository.findById(id).get().getColor());
        car.setEngine(carsRepository.findById(id).get().getEngine());
        car.setRentedBy(null);
        return car;
    }

}
