package com.example.commerciale.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.commerciale.models.Proformatmain;
import com.example.commerciale.repository.MyProformatRepository;
@Service
public class MyProformatService {
    @Autowired
    private MyProformatRepository myProformatRepository; 
    public List<Proformatmain> getProformatAll(){
        return myProformatRepository.findAll();
    }
    public List<Proformatmain> getProformatDetail() {
        return myProformatRepository.getProformatById_mere();
    }
}
