package org.polytech.covid.domain;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
    private Integer id;

    private String mail;
    private String phoneNumber;

    private String firstName;
    private String lastName;

    @Nullable
    private Integer vaccinated;

    private Integer acces;

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() 
    { 
        return firstName; 
    }

    public String getLastName() 
    { 
        return lastName; 
    }

    public Integer getVaccinated() 
    { 
        return vaccinated; 
    }

    public Integer getAcces() 
    { 
        return acces; 
    }

    public void setMail(String mail) 
    { 
        this.mail = mail; 
    }

    public void setPhoneNumber(String phoneNumber) 
    { 
        this.phoneNumber = phoneNumber; 
    }

    public void setFirstName(String firstName) 
    { 
        this.firstName = firstName; 
    }

    public void setLastName(String lastName) 
    { 
        this.lastName = lastName; 
    }

    public void setVaccinated(Integer vaccinated) 
    { 
        this.vaccinated = vaccinated; 
    }

    public void setAcces(Integer acces) 
    { 
        this.acces = acces; 
    }
}
