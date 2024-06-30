package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    public List<Car> getSeveralCars(List<Car> cars, int count);
}
