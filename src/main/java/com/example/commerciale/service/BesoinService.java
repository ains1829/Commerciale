package com.example.commerciale.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.Besoinmain;
import com.example.commerciale.repository.BesoinRepository;

@Service
public class BesoinService {
    @Autowired
    private BesoinRepository besoinRepository;
    public List<Besoinmain> getBesoin(){
        return besoinRepository.findAll();
    }
    public List<Besoinmain> getBesoinAllBydate(Date datess){
        return besoinRepository.getBesoinMainDate(datess) ;
    }
    public List<Date> getDateG(){
        return besoinRepository.getDateGroupement() ;
    }
}
