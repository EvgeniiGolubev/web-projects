package com.example.controllers;

import com.example.dao.PersonDAO;
import com.example.models.Person;
import com.example.models.User;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String main() {
        return "main-page";
    }

    @GetMapping("/login")
    public String loginRequest(@ModelAttribute("user") User user) {
        return "login/login-page";
    }

    @GetMapping("/registration")
    public String registrationRequest() {
        return "registration/registration-page";
    }

    @PostMapping("/login")
    public String loginResponse(@ModelAttribute("user") User user) {
        //TODO проверять юзера
        System.out.println(user);
        return "redirect:/people";
    }

    @PostMapping("/registration")
    public String registrationResponse() {
        return null;
    }

    @GetMapping("/people")
    public String showAllPeople(Model model) {
        model.addAttribute("people", personService.getAllPeople());
        return "people/allPeople";
    }

}
