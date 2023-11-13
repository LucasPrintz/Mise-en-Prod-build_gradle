package org.polytech.covid.service;

import java.util.List;

import org.polytech.covid.domain.User;
import org.polytech.covid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository clientRepository;
    
    public List<User> findAllByFirstNameOrLastName(String firstName, String lastName) {
        return clientRepository.findAllByFirstNameOrLastName(firstName, lastName);
    }

    public List<User> findAll() {
        return clientRepository.findAll();
    }

    public User validateVaccine(Integer id) {
        User client = clientRepository.findById(id).get();
        client.setVaccinated(id);
        return clientRepository.save(client);
    }
}
