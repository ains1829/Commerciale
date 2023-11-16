package com.example.commerciale.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commerciale.service.MyProformatService;
import com.example.commerciale.models.Proformatmain;
@RestController
@RequestMapping("/testcontroller")
public class PostmanController {
    @Autowired
    MyProformatService proformatService ;
    @GetMapping("/allproformat")
    public List<Proformatmain> getAllProformats() {
        return proformatService.getProformatAll() ;
    }
}
