package com.example.foru.controllers;

import com.example.foru.entities.Customer;
import com.example.foru.repository.CustomerRepository;
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
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public String showIndex(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Customer customer) {
        return "add-customer";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute ("customer") @Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
           return "add-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Customer customer,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        customerRepository.delete(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:";
    }
}
