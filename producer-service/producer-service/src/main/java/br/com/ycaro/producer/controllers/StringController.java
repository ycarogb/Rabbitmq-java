package br.com.ycaro.producer.controllers;

import br.com.ycaro.producer.services.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class StringController {

    private final StringService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam ("message") String message){
        service.produce(message);
        return ResponseEntity.ok().body("Sending message");
    }
}
