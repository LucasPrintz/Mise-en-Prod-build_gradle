package org.polytech.covid.service;

import java.util.List;

import org.polytech.covid.domain.VaccinationCenter;
import org.polytech.covid.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
    
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public List<VaccinationCenter> findAllByCity(String cityName) {
        return vaccinationCenterRepository.findAllByCity(cityName);
    }

    public List<VaccinationCenter> findAll() {
        return vaccinationCenterRepository.findAll();
    }

    public VaccinationCenter addVaccinationCenter(String name, String city, String address) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter(name, city, address);
        return vaccinationCenterRepository.save(vaccinationCenter);
    }

    public VaccinationCenter updateVaccinationCenter(Integer id, String name, String city, String address) {
        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findById(id).get();
        vaccinationCenter.setName(name);
        vaccinationCenter.setCity(city);
        vaccinationCenter.setAddress(address);
        return vaccinationCenterRepository.save(vaccinationCenter);
    }

    public void deleteVaccinationCenter(Integer id) {
        vaccinationCenterRepository.deleteById(id);
    }
}
