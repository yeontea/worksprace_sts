package com.green.Car.controller;

import com.green.Car.service.CarService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {
    @Resource(name="carService")
    CarService carService;


    @GetMapping("/")
    public String main(){
        return "content/car/car_manage_system";
    }
}
