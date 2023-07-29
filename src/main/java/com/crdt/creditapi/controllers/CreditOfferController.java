package com.crdt.creditapi.controllers;

import com.crdt.creditapi.constants.ApiServiceUrl;
import com.crdt.creditapi.constants.ErrorConstants;
import com.crdt.creditapi.dto.CreditLimitOfferDto;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import com.crdt.creditapi.services.ServiceCore;
import com.crdt.creditapi.utilities.WebServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreditOfferController {
    private static final Logger logger = LogManager.getLogger(CreditOfferController.class);

    @Autowired
    ServiceCore serviceCore;

    @GetMapping("/greet")
    public String greetMessage() {
        return "Good day to you";
    }

    @PostMapping(value = ApiServiceUrl.V1_API_URL + ApiServiceUrl.CREATE_LIMIT_OFFER_API_URL)
    public ResponseEntity<CreditLimitOfferDto> createLimitOffer(@Valid @RequestBody CreditLimitOfferRequest creditLimitOfferRequest) throws WebServiceException {
        try {
            logger.info("input :: {}", creditLimitOfferRequest.toString());
            CreditLimitOfferDto creditLimitOfferResponse = null;
            creditLimitOfferResponse = serviceCore.createLimitOffer(creditLimitOfferRequest);
            return new ResponseEntity<>(creditLimitOfferResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new WebServiceException(ErrorConstants.ERROR_STATUS_CODE_500, ErrorConstants.ERROR_STATUS_CODE_500_MESSAGE);
        }
    }

}
