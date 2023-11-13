package org.polytech.covid.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "centre_vaccination")
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(mappedBy = "vaccinationCenter", fetch = FetchType.LAZY, orphanRemoval = false)
    private Integer id;
    private String name;

    private String address;
    private String city;

    public VaccinationCenter(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() 
    { 
        return address; 
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) 
    { 
        this.name = name; 
    }

    public void setAddress(String address) 
    { 
        this.address = address; 
    }

    public void setCity(String city) 
    { 
        this.city = city; 
    }

}
