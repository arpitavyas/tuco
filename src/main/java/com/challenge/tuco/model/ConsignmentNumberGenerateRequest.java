package com.challenge.tuco.model;

public class ConsignmentNumberGenerateRequest {

    String carrierName;

    String accountNumber;

    int digits;

    int lastUsedIndex;

    int rangeStart;

    int rangeEnd;


    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public int getLastUsedIndex() {
        return lastUsedIndex;
    }

    public void setLastUsedIndex(int lastUsedIndex) {
        this.lastUsedIndex = lastUsedIndex;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    @Override
    public String toString() {
        return "ConsignmentNumberGenerateRequest{" +
                "carrierName='" + carrierName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", digits=" + digits +
                ", lastUsedIndex=" + lastUsedIndex +
                ", rangeStart=" + rangeStart +
                ", rangeEnd=" + rangeEnd +
                '}';
    }
}
