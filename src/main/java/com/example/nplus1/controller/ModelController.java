package com.example.nplus1.controller;

import com.example.nplus1.model.Model;
import com.example.nplus1.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/all")
    public ResponseEntity<List<Model>> getAll(){
        return ResponseEntity.ok().body(modelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Model>> getByManufacturerId(@PathVariable("id") long id){
        return ResponseEntity.ok().body(modelService.findByManufacturerId(id));
    }

    @GetMapping("/allbetween")
    public ResponseEntity<List<Model>> getByYear(@RequestParam("minYear") int minYear,
                                                 @RequestParam("maxYear") int maxYear){
        return ResponseEntity.ok().body(modelService.findAllBetween(minYear, maxYear));
    }
}
