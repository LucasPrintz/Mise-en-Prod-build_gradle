package org.polytech.covid.repository;

import java.util.List;

import org.polytech.covid.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    public List<User> findAllByFirstNameOrLastName(String firstName, String lastName);

    public List<User> findAll();
}
