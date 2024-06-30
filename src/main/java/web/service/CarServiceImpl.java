package web.service;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {
        this.cars = List.of(
                new Car("Nissan", "Blue", "Japan"),
                new Car("BMW", "Black", "Germany"),
                new Car("Lada", "Cherry", "Russia"),
                new Car("Chevrolet", "White", "USA"),
                new Car("Ferrari", "Red", "Italy")
        );
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getSeveralCars(List<Car> cars, int count) {
        return cars.subList(0, count);
    }

}
