package com.challenge.tuco.repository;

import com.challenge.tuco.model.CarrierCompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierCompanyRepository extends JpaRepository<CarrierCompanyModel, Integer> {

    CarrierCompanyModel findCarrierCodeByCarrierName(String carrierCompany);
}
