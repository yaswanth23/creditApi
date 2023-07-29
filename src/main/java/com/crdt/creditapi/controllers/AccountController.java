package com.crdt.creditapi.controllers;

import com.crdt.creditapi.constants.ApiServiceUrl;
import com.crdt.creditapi.constants.ErrorConstants;
import com.crdt.creditapi.dto.AccountDto;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.services.ServiceCore;
import com.crdt.creditapi.utilities.WebServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountController {
    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    ServiceCore serviceCore;

@PostMapping(value = ApiServiceUrl.V1_API_URL + ApiServiceUrl.CREATE_CUSTOMER_ACCOUNTS_API_URL)
    public ResponseEntity<AccountDto> createCustomerAccount(@Valid @RequestBody AccountRequest accountRequest) throws WebServiceException {
    try{
        logger.info("input :: {}", accountRequest.toString());
        AccountDto accountDtoResponse = null;
        accountDtoResponse = serviceCore.createCustomerAccount(accountRequest);
        return new ResponseEntity<>(accountDtoResponse, HttpStatus.OK);
    } catch (Exception e) {
        throw new WebServiceException(ErrorConstants.ERROR_STATUS_CODE_500, ErrorConstants.ERROR_STATUS_CODE_500_MESSAGE);
    }
}
}
