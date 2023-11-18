package com.example.commerciale.controller;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping("/logincontroller")
public class LoginContoller {
    @PostMapping("/login")
    public String login(@RequestParam("email") String email , @RequestParam("password") String password){
        System.out.println(email);
        System.out.println(password);
        return "Bandecommande" ;
    }
}
