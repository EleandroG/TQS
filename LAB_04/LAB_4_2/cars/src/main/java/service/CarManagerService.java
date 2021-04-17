package service;

import entities.Car;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.List;

@Service
public class CarManagerService {

    private CarRepository carRepository;

    //public Car save(Car car) {} ???
    public void save(Car car) {
        boolean savedCar = (car.getId() != null);
        if(savedCar) {
            Car existingCar = carRepository.findByCarId(car.getId());
        }
        carRepository.save(car);
    }

    public List<Car> getAllCars()  {
        return carRepository.findAll();
    }

    public Car getCarDetails(Long id) {
        return carRepository.findByCarId(id);
    }
}
