package com.ambulaproject.locationproblem;

import com.ambulaproject.locationproblem.API.Update_data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LocationProblemApplication {
    public static void main(String[] args) {

        SpringApplication.run(LocationProblemApplication.class, args);
    }
}
