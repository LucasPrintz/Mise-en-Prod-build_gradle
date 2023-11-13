package org.polytech.covid.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateur_centre_vaccination")
public class UserVaccinationCenter {
    @Id
    private Integer id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user.id")
    private Integer userId;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "vaccination_center.id")
    private Integer vaccinationCenterId;

    @Nullable    
    private String date;

    private String acces;

    public UserVaccinationCenter(Integer userId, Integer vaccinationCenterId, String acces) {
        this.userId = userId;
        this.vaccinationCenterId = vaccinationCenterId;
        this.acces = acces;
    }

    public UserVaccinationCenter(Integer userId, Integer vaccinationCenterId, String date, String acces) {
        this.userId = userId;
        this.vaccinationCenterId = vaccinationCenterId;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getVaccinationCenterId() {
        return vaccinationCenterId;
    }

    public String getDate() {
        return date;
    }

    public String getAcces() {
        return acces;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setVaccinationCenterId(Integer vaccinationCenterId) {
        this.vaccinationCenterId = vaccinationCenterId;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }
}
