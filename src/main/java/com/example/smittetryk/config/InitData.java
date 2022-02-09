package com.example.smittetryk.config;

import com.example.smittetryk.model.County;
import com.example.smittetryk.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

  @Autowired
  CountyRepository countyRepository;

  @Override
  public void run(String... args) throws Exception {
    County county = new County();
    county.setName("Roskilde");
    county.setCountyCode("0265");
    county.setHref("http://localhost:8080/county/0265");
    countyRepository.save(county);

    county.setName("Køge");
    county.setCountyCode("0259");
    county.setHref("http://localhost:8080/county/0259");
    countyRepository.save(county);

  }


}
