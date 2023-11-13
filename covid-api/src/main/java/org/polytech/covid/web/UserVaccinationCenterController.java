package org.polytech.covid.web;

import java.util.List;

import org.polytech.covid.domain.UserVaccinationCenter;
import org.polytech.covid.service.UserVaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserVaccinationCenterController {
    
    @Autowired
    private UserVaccinationCenterService userVaccinationCenterService;
    
    @RequestMapping(path = "/api/userVaccinationCenters/public/addReservation/{userId}/{vaccinationCenterId}/{date}", method = RequestMethod.POST)
    public UserVaccinationCenter addReservation(@PathVariable("userId") Integer userId, @PathVariable("vaccinationCenterId") Integer vaccinationCenterId, @PathVariable("date") String date) {
        return userVaccinationCenterService.addReservation(userId, vaccinationCenterId, date);
    }

    @RequestMapping(path = "/api/userVaccinationCenters/admin/addAdminCenter/{userId}/{vaccinationCenterId}", method = RequestMethod.POST)
    public UserVaccinationCenter addAdminCenter(@PathVariable("userId") Integer userId, @PathVariable("vaccinationCenterId") Integer vaccinationCenterId) {
        return userVaccinationCenterService.addAdminCenter(userId, vaccinationCenterId);
    }

    @RequestMapping(path = "/api/userVaccinationCenters/admin/searchByUser/{userId}", method = RequestMethod.GET)
    public List<UserVaccinationCenter> getByUserId(@PathVariable("userId") Integer userId) {
        return userVaccinationCenterService.findAllByUserId(userId);
    }

    @RequestMapping(path = "/api/userVaccinationCenters/admin/searchByVaccinationCenter/{vaccinationCenterId}", method = RequestMethod.GET)
    public List<UserVaccinationCenter> getByCenterId(@PathVariable("vaccinationCenterId") Integer vaccinationCenterId) {
        return userVaccinationCenterService.findAllByVaccinationCenterId(vaccinationCenterId);
    }

    @RequestMapping(path = "/api/userVaccinationCenters/admin/getAll", method = RequestMethod.GET)
    public List<UserVaccinationCenter> getAll() {
        return userVaccinationCenterService.findAll();
    }

    @RequestMapping(path = "/api/userVaccinationCenters/admin/update/{id}/{userId}/{vaccinationCenterId}", method = RequestMethod.PUT)
    public UserVaccinationCenter update(@PathVariable("id") Integer id, @PathVariable("userId") Integer userId, @PathVariable("vaccinationCenterId") Integer vaccinationCenterId) {
        return userVaccinationCenterService.update(id, userId, vaccinationCenterId);
    }
    
    @RequestMapping(path = "/api/userVaccinationCenters/admin/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        userVaccinationCenterService.delete(id);
    }
}
