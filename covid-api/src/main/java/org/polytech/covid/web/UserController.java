package org.polytech.covid.web;

import java.util.List;

import org.polytech.covid.domain.User;
import org.polytech.covid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService clientService;

    @RequestMapping(path = "/api/clients/admin/getByFirstNameOrLastName/{firstName}/{lastName}", method = RequestMethod.GET)
    public List<User> get(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return clientService.findAllByFirstNameOrLastName(firstName, lastName);
    }

    @GetMapping(path = "/api/clients/admin/getAll")
    public List<User> getAll() {
        return clientService.findAll();
    }

    @RequestMapping(path = "/api/clients/admin/validateVaccine/{id}", method = RequestMethod.PUT)
    public User validateVaccine(@PathVariable("id") Integer id) {
        return clientService.validateVaccine(id);
    }
}
