package com.example.smittetryk;

import com.example.smittetryk.model.County;
import com.example.smittetryk.repository.CountyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SmittetrykApplicationTests {
  @Autowired
  CountyRepository countyRepository;

  @Test
  void contextFonc() {
    List<County> counties =  countyRepository.findAll();
    Assertions.assertEquals(2,counties.size());


  }

}
