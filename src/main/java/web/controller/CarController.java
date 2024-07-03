package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiseImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private static List<Car> cars = new ArrayList<Car>();

    {
        cars.add(new Car("CHINA","OMODA", 2023));
        cars.add(new Car("KOREA","HYUNDAI", 2020));
        cars.add(new Car("GERMANY","BMW", 2015));
        cars.add(new Car("JAPAN","MAZDA", 2019));
        cars.add(new Car("CHINA","CHANGAN", 2022));
    }
    @Autowired
    private CarServiseImpl carServise;

    @GetMapping("/{count}")
    public String returnCars(@RequestParam(name = "count", defaultValue = "5")int amount, Model model) {
       model.addAttribute("cars",carServise.returnCar(cars, amount));
        return "cars";

    }
}
