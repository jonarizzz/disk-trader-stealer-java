package com.example.disktraderstealerjava.web;

import com.example.disktraderstealerjava.service.StealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StealerController {

    private final StealerService stealerService;

    @RequestMapping("/stealAll")
    public ResponseEntity<String> stealAll(){
        stealerService.stealAllGames();
        return new ResponseEntity<>("Stealing of all games finished", HttpStatus.OK);
    }

}
