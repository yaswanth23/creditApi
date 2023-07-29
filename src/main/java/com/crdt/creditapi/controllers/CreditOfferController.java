package com.crdt.creditapi.controllers;

import com.crdt.creditapi.constants.ApiServiceUrl;
import com.crdt.creditapi.dto.CreditCreateResDto;
import com.crdt.creditapi.dto.LimitOfferDto;
import com.crdt.creditapi.dto.UpdateCreditLimitResDto;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import com.crdt.creditapi.requests.UpdateCreditLimitRequest;
import com.crdt.creditapi.services.ServiceCore;
import com.crdt.creditapi.utilities.WebServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CreditOfferController {
    private static final Logger logger = LogManager.getLogger(CreditOfferController.class);

    @Autowired
    ServiceCore serviceCore;

    @PostMapping(value = ApiServiceUrl.V1_API_URL + ApiServiceUrl.CREATE_LIMIT_OFFER_API_URL)
    public ResponseEntity<CreditCreateResDto> createLimitOffer(@Valid @RequestBody CreditLimitOfferRequest creditLimitOfferRequest) throws WebServiceException {
        logger.info("input createLimitOffer :: {}", creditLimitOfferRequest.toString());
        CreditCreateResDto creditLimitOfferResponse = serviceCore.createLimitOffer(creditLimitOfferRequest);
        return new ResponseEntity<>(creditLimitOfferResponse, HttpStatus.OK);
    }

    @GetMapping(value = ApiServiceUrl.V1_API_URL + ApiServiceUrl.GET_LIMIT_OFFER_API_URL)
    public ResponseEntity<List<LimitOfferDto>> getLimitOffers(
            @PathVariable(name = "account_id") Long account_id,
            @RequestParam(value = "activeDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime activeDate) throws WebServiceException {

        logger.info("input getLimitOffers :: {}", account_id);
        List<LimitOfferDto> limitOfferResponse = serviceCore.getLimitOffers(account_id, activeDate);
        return new ResponseEntity<>(limitOfferResponse, HttpStatus.OK);
    }

    @PatchMapping(value = ApiServiceUrl.V1_API_URL + ApiServiceUrl.UPDATE_LIMIT_OFFER_STATUS_API_URL)
    public ResponseEntity<UpdateCreditLimitResDto> updateCreditLimit(@PathVariable(name = "limit_offer_id") Long limit_offer_id, @RequestBody @Valid UpdateCreditLimitRequest updateCreditLimitRequest) throws WebServiceException {
        logger.info("input updateCreditLimit :: limit_offer_id: {}, updateCreditLimitRequest: {}", limit_offer_id, updateCreditLimitRequest);
        UpdateCreditLimitResDto updateCreditLimitResponse = serviceCore.updateCreditLimit(limit_offer_id, updateCreditLimitRequest);
        return new ResponseEntity<>(updateCreditLimitResponse, HttpStatus.OK);
    }

}
