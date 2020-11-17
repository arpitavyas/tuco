package com.challenge.tuco.service;

import com.challenge.tuco.Exception.TucoServiceException;
import com.challenge.tuco.model.CarrierCompanyModel;
import com.challenge.tuco.model.ConsignmentNumberGenerateRequest;
import com.challenge.tuco.repository.CarrierCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TucoService {

    @Autowired
    CarrierCompanyRepository repository;

    public String generateConsignmentNoteNumber(ConsignmentNumberGenerateRequest request) throws TucoServiceException {

//        find prefix from H2 database based on carrier name in request
        CarrierCompanyModel model = repository.findCarrierCodeByCarrierName(request.getCarrierName());

        if (model == null || model.getCarrierCode().equals("")) {
            throw new TucoServiceException("Invalid Carrier company name for request:"+request.getCarrierName());
        }

        String accountNumber = request.getAccountNumber();
        int digits = request.getDigits();
        int consignmentIndex = request.getLastUsedIndex() + 1;

        if (!checkRange(consignmentIndex, request.getRangeStart(), request.getRangeEnd())) {
            throw new TucoServiceException("Invalid Consignment Index for range: "+request.getRangeStart()+" to "+request.getRangeEnd());
        }
        String numberDigits = setDigitsFormat(consignmentIndex, digits);
        int checkSum = calculateCheckSum(numberDigits);

        return model.getCarrierCode()+accountNumber+numberDigits+checkSum;
    }

    public boolean checkRange(int consignmentIndex, int rangeStart, int rangeEnd) {
        return consignmentIndex >= rangeStart && consignmentIndex <= rangeEnd;
    }

    public int calculateCheckSum(String consignmentIndex) {
        int sum1 =0;
        int sum2 =0;
        for (int i=consignmentIndex.length()-1; i>=0; i = i-2) {
            sum1 = sum1 + Integer.parseInt(String.valueOf(consignmentIndex.charAt(i)));
        }
        for (int i=consignmentIndex.length()-2; i>=0; i = i-2) {
            sum2 = sum2 + Integer.parseInt(String.valueOf(consignmentIndex.charAt(i)));
        }
        sum1 = sum1*3;
        sum2 = sum2*7;
        int total = sum1+sum2;
        int nextMultipleOfTen = ((total + 9) / 10) * 10;

        return (nextMultipleOfTen-total);
    }

    public String setDigitsFormat(int consignmentIndex, int digits) {
        String form = "%0"+digits+"d";
        return String.format(form, consignmentIndex);
    }
}
