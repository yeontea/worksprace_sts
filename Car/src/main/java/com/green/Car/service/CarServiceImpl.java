package com.green.Car.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carService")
public class CarServiceImpl implements CarService{
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
}
