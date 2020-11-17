package com.challenge.tuco.controller;


import com.challenge.tuco.Exception.TucoServiceException;
import com.challenge.tuco.message.ResponseMessage;
import com.challenge.tuco.model.ConsignmentNumberGenerateRequest;
import com.challenge.tuco.service.TucoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TucoController {

    @Autowired
    TucoService tucoService;

    @PostMapping(path = "/api/generateConnoteNumber")
    public ResponseEntity<ResponseMessage> connoteNumber(@RequestBody ConsignmentNumberGenerateRequest request)
    {
        try {
            String number = tucoService.generateConsignmentNoteNumber(request);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(number));
        } catch (TucoServiceException e)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getLocalizedMessage()));
        }
    }
}
