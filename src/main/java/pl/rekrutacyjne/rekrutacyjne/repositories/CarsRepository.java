package pl.rekrutacyjne.rekrutacyjne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rekrutacyjne.rekrutacyjne.entities.Cars;


@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

}
