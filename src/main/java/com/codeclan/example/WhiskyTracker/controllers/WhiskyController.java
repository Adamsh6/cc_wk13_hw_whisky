package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public List<Whisky> getAllWhiskies(){
        return whiskyRepository.findAll();
    }

    @GetMapping(value = "/year/{year}")
    public List<Whisky> getWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.getByYear(year);
    }

    @GetMapping(value = "/distillery&age/{id}/{age}")
    public List<Whisky> getWhiskiesByDistilleryAndAge(@PathVariable Long id, @PathVariable int age){
        return whiskyRepository.findWhiskiesByDistilleryAndAge(id, age);
    }

    @GetMapping(value = "/region/{region}")
    public List<Whisky> getWhiskiesByRegion(@PathVariable String region){
        return whiskyRepository.findWhiskiesByRegion(region);
    }
}
