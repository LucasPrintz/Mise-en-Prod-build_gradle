package org.polytech.covid.service;

import java.util.List;

import org.polytech.covid.domain.UserVaccinationCenter;
import org.polytech.covid.repository.UserVaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVaccinationCenterService {
    
    @Autowired
    private UserVaccinationCenterRepository userVaccinationCenterRepository;

    public UserVaccinationCenter addReservation(Integer clientId, Integer vaccinationCenterId, String date) {
        UserVaccinationCenter userVaccinationCenter = new UserVaccinationCenter(clientId, vaccinationCenterId, date);
        return userVaccinationCenterRepository.save(userVaccinationCenter);
    }

    public UserVaccinationCenter addAdminCenter(Integer clientId, Integer vaccinationCenterId) {
        UserVaccinationCenter userVaccinationCenter = new UserVaccinationCenter(clientId, vaccinationCenterId, "admin");
        return userVaccinationCenterRepository.save(userVaccinationCenter);
    }

    public List<UserVaccinationCenter> findAllByUserId(Integer userId) {
        return userVaccinationCenterRepository.findAllByUserId(userId);
    }

    public List<UserVaccinationCenter> findAllByVaccinationCenterId(Integer vaccinationCenterId) {
        return userVaccinationCenterRepository.findAllByVaccinationCenterId(vaccinationCenterId);
    }

    public List<UserVaccinationCenter> findAll() {
        return userVaccinationCenterRepository.findAll();
    }

    public UserVaccinationCenter update(Integer id, Integer userId, Integer vaccinationCenterId) {
        UserVaccinationCenter userVaccinationCenter = userVaccinationCenterRepository.findById(id).get();
        userVaccinationCenter.setUserId(userId);
        userVaccinationCenter.setVaccinationCenterId(vaccinationCenterId);
        return userVaccinationCenterRepository.save(userVaccinationCenter);
    }

    public void delete(Integer id) {
        userVaccinationCenterRepository.deleteById(id);
    }
}
