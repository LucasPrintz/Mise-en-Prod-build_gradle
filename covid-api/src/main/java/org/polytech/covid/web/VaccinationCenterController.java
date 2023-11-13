package org.polytech.covid.web;

import java.util.List;

import org.polytech.covid.domain.VaccinationCenter;
import org.polytech.covid.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaccinationCenterController {
    
    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @GetMapping(path = "/api/centers/public/getByCity{city}")
    public List<VaccinationCenter> get(@PathVariable("city") String city) {
        return vaccinationCenterService.findAllByCity(city);
    }

    @GetMapping(path = "/api/centers/public/getAll")
    public List<VaccinationCenter> getAll() {
        return vaccinationCenterService.findAll();
    }

    @GetMapping(path = "/api/centers/admin/create/{name}/{city}/{address}")
    public VaccinationCenter addVaccinationCenter(@PathVariable("name") String name, @PathVariable("city") String city, @PathVariable("address") String address) {
        return vaccinationCenterService.addVaccinationCenter(name, city, address);
    }

    @GetMapping(path = "/api/centers/admin/update/{id}/{name}/{city}/{address}")
    public VaccinationCenter updateVaccinationCenter(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable("city") String city, @PathVariable("address") String address) {
        return vaccinationCenterService.updateVaccinationCenter(id, name, city, address);
    }

    @GetMapping(path = "/api/centers/admin/delete/{id}")
    public void deleteVaccinationCenter(@PathVariable("id") Integer id) {
        vaccinationCenterService.deleteVaccinationCenter(id);
    }
}
