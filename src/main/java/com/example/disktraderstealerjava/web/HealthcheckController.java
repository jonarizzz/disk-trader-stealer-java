package com.example.disktraderstealerjava.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @RequestMapping("/healthcheck")
    public ResponseEntity<String> healthcheck (){
        return new ResponseEntity<>("I'm alive, man", HttpStatus.OK);
    }

}
