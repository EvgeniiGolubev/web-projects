package com.example.controllers;

import com.example.models.Person;
import com.example.models.User;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public String loginResponse(@ModelAttribute("user") User user) {
        //TODO проверять юзера
        System.out.println(user);
        return "redirect:/people";
    }

    @GetMapping("/registration")
    public String registrationRequest() {
        return "registration/registration-page";
    }

    @PostMapping("/registration")
    public String registrationResponse() {
        return null;
    }

    @GetMapping("/people")
    public String showAllPeople(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", personService.getAllPeople());
        return "people/all-people-page";
    }

    @PostMapping("/people")
    public String addNewPerson(@ModelAttribute("person") Person person) {
        personService.addPerson(person);
        System.out.println(person);
        return "redirect:/people";
    }

    @GetMapping("/people/{id}")
    public String showPerson(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.getPersonById(id));
        return "people/person-info-page";
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return "redirect:/people";
    }

    @PatchMapping("/people/{id}")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personService.updatePerson(id, person);
        return "redirect:/people/" + id;
    }

}
