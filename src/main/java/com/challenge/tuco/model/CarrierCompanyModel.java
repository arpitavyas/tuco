package com.challenge.tuco.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CARRIER_COMPANY")
public class CarrierCompanyModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int carrierId;

  @Column(name="carrier_name")
  private String carrierName;

  @Column(name="carrier_code")
  private String carrierCode;

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    @Override
    public String toString() {
        return "CarrierCompanyModel{" +
                "carrierId=" + carrierId +
                ", carrierName='" + carrierName + '\'' +
                ", carrierCode='" + carrierCode + '\'' +
                '}';
    }
}
