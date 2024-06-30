package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarServiceImpl carService;

    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getSeveralCarsByCount(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        if (count > 5) {
            count = 5;
        }
        model.addAttribute("cars", carService.getSeveralCars(carService.getCars(), count));
        return "cars";
    }
}
