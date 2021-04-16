package controller;

import entities.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import service.CarManagerService;

import java.util.List;

@RestController
public class CarController {

    private CarManagerService carManagerService;

    /*public ResponseEntity<Car> createCar(CarManagerService car) {

    }*/

    public List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }

    public Car getCarById(Long id) {
        return carManagerService.getCarDetails(id);
    }

}
