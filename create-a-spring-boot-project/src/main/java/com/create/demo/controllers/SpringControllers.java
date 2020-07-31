package com.create.demo.controllers;


import com.create.demo.models.SpringModels;
import com.create.demo.services.interfaces.SpringServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring")
public class SpringControllers {
    private final SpringServices springServices;

    public SpringControllers(SpringServices springServices) {
        this.springServices = springServices;
    }

    @GetMapping
    public ResponseEntity<List<SpringModels>> getAll() {
        return new ResponseEntity<>(springServices.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpringModels> getAModelById(@PathVariable String id) {
        return new ResponseEntity<>(springServices.getAModelById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpringModels> updateAModelById(@PathVariable String id, @RequestBody SpringModels request) {
        return new ResponseEntity<>(springServices.updateAModelById(id, request), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SpringModels> createAModel(@RequestBody SpringModels request) {
        return new ResponseEntity<>(springServices.createAModel(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAModelById(@PathVariable String id) {
        springServices.deleteAModelById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getallbystt/{stt}")
    public ResponseEntity<List<SpringModels>> getAllByStt(@PathVariable int stt) {
        return new ResponseEntity<>(springServices.getAllByStt(stt), HttpStatus.OK);
    }


}
