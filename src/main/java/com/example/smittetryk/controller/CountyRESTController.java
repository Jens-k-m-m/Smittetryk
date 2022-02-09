package com.example.smittetryk.controller;


import com.example.smittetryk.model.County;
import com.example.smittetryk.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountyRESTController {

  @Autowired
  CountyRepository countyRepository;

  @GetMapping("/counties")
  public List<County> getAllCounties() {
    return countyRepository.findAll();
  }


  @GetMapping("/")
  public String hej() {
    return "Hello World";
  }


  // Finder en kommune
  @GetMapping("/county/{id}")
  public County findCountById(@PathVariable String id) {
    //JPA retuner Optional<Coiny
    Optional<County> obj = countyRepository.findById(id);
    //Hvis den finde en obj
    if (obj.isPresent()) {
      return obj.get();
    } else {
      return null;
    }
    //http://localhost:8080/counties når du kilke på den like skulle den sende dif vidre til den like,
    // http://localhost:8080/county/0259
  }

  @PostMapping("/county")
  @ResponseStatus(HttpStatus.CREATED)
  public County postCounty(@RequestBody County county) {
    System.out.println(county);
    return countyRepository.save(county);
  }


  @PutMapping("/county/{id}")
  public ResponseEntity<County> updateCount(@PathVariable String id, @RequestBody County county) {
    Optional<County> optCounty = countyRepository.findById(id);
    if (optCounty.isPresent()) {
      countyRepository.save(county);
      return new ResponseEntity<County>(county, HttpStatus.OK);
    } else {
      County notFoundCounty = new County();
      notFoundCounty.setName("Jeg kunne ikke finde id=" + id);
      return new ResponseEntity<County>(notFoundCounty, HttpStatus.NOT_FOUND);
    }
  }


}
