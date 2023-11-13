package org.polytech.covid.repository;

import java.util.List;

import org.polytech.covid.domain.User;
import org.polytech.covid.domain.UserVaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVaccinationCenterRepository extends JpaRepository<UserVaccinationCenter, Integer>
{
    public List<UserVaccinationCenter> findAllByUserId(Integer userId);
    public List<UserVaccinationCenter> findAllByVaccinationCenterId(Integer vaccinationCenterId);
    public List<UserVaccinationCenter> findAll();
}
