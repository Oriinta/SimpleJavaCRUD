package com.example.foru.controllers;

import com.example.foru.entities.Person;
import com.example.foru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String showIndex(Model model) {
        model.addAttribute("persons", userRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Person person) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute ("person") @Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
           return "add-user";
        }

        userRepository.save(person);
        model.addAttribute("persons", userRepository.findAll());
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Person person = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("person", person);
        return "update-user";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Person person,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            person.setId(id);
            return "update-user";
        }

        userRepository.save(person);
        model.addAttribute("persons", userRepository.findAll());
        return "redirect:";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Person person = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(person);
        model.addAttribute("persons", userRepository.findAll());
        return "redirect:";
    }
}
