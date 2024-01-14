package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String show(@RequestParam(name = "count", defaultValue = "5") Integer count, Model model) {
        List<Car> carsList;
        if(count >= 5){
            carsList = carService.carList();
        } else {
            carsList = carService.showCar(count);
        }
        model.addAttribute("carsTable", carsList);
        return "cars";
    }

}
