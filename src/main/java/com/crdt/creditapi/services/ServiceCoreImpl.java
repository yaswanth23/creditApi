package com.crdt.creditapi.services;

import com.crdt.creditapi.dto.AccountDto;
import com.crdt.creditapi.dto.CreditLimitOfferDto;
import com.crdt.creditapi.entities.AccountsEntity;
import com.crdt.creditapi.repositories.AccountRepository;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ServiceCoreImpl implements ServiceCore {
    private static final Logger logger = LogManager.getLogger(ServiceCoreImpl.class);

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountDto createCustomerAccount(AccountRequest accountRequest) {
        logger.info("Inside create customer account: {}", accountRequest);
        AccountDto response = new AccountDto();

        AccountsEntity createCustAccount = new AccountsEntity();
        createCustAccount.setCustomer_id(accountRequest.getCustomer_id());
        createCustAccount.setAccount_limit(accountRequest.getAccount_limit());
        createCustAccount.setPer_transaction_limit(accountRequest.getPer_transaction_limit());
        createCustAccount.setAccount_limit_update_time(LocalDateTime.now());
        createCustAccount.setPer_transaction_limit_update_time(LocalDateTime.now());

        accountRepository.saveAndFlush(createCustAccount);

        Long accountId = createCustAccount.getAccount_id();

        response.setStatusCode("200");
        response.setStatusMessage("success");
        response.setAccount_id(accountId);
        return response;
    }

    @Override
    public CreditLimitOfferDto createLimitOffer(CreditLimitOfferRequest creditLimitOfferRequest) {
        logger.info("Inside create limit offer: {}", creditLimitOfferRequest);
        CreditLimitOfferDto response = new CreditLimitOfferDto();
        response.setStatusCode("200");
        response.setStatusMessage("success");
        return response;
    }
}
