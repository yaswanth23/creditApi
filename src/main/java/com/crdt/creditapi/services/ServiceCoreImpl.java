package com.crdt.creditapi.services;

import com.crdt.creditapi.constants.CommonConstants;
import com.crdt.creditapi.constants.ErrorConstants;
import com.crdt.creditapi.dto.AccountCreateResDto;
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
    public AccountCreateResDto createCustomerAccount(AccountRequest accountRequest) {
        logger.info("Inside create customer account: {}", accountRequest);
        AccountCreateResDto response = new AccountCreateResDto();

        AccountsEntity createCustAccount = new AccountsEntity();
        createCustAccount.setCustomer_id(accountRequest.getCustomer_id());
        createCustAccount.setAccount_limit(accountRequest.getAccount_limit());
        createCustAccount.setPer_transaction_limit(accountRequest.getPer_transaction_limit());
        createCustAccount.setAccount_limit_update_time(LocalDateTime.now());
        createCustAccount.setPer_transaction_limit_update_time(LocalDateTime.now());

        accountRepository.saveAndFlush(createCustAccount);

        Long accountId = createCustAccount.getAccountId();

        response.setStatusCode(CommonConstants.STATUS_CODE_200);
        response.setStatusMessage(CommonConstants.ACCOUNT_CREATED_STATUS_CODE_MESSAGE);
        response.setAccount_id(accountId);
        logger.info("create customer account response: {}", response.toString());
        return response;
    }

    @Override
    public AccountDto getAccountDetails(Long account_id) {
        logger.info("Inside get account details: {}", account_id);
        AccountDto response = new AccountDto();
        AccountsEntity accountsDetails = accountRepository.findByAccountId(account_id);
        if (accountsDetails != null) {
            response.setStatusCode(CommonConstants.STATUS_CODE_200);
            response.setStatusMessage(CommonConstants.STATUS_CODE_200_MESSAGE);
            response.setAccount_id(accountsDetails.getAccountId());
            response.setCustomer_id(accountsDetails.getCustomer_id());
            response.setAccount_limit(accountsDetails.getAccount_limit());
            response.setPer_transaction_limit(accountsDetails.getPer_transaction_limit());
            response.setLast_account_limit(accountsDetails.getLast_account_limit());
            response.setLast_per_transaction_limit(accountsDetails.getLast_per_transaction_limit());
            response.setAccount_limit_update_time(accountsDetails.getAccount_limit_update_time());
            response.setPer_transaction_limit_update_time(accountsDetails.getPer_transaction_limit_update_time());
        } else {
            response.setStatusCode(ErrorConstants.ERROR_STATUS_CODE_404);
            response.setStatusMessage(ErrorConstants.ERROR_STATUS_CODE_404_MESSAGE);
        }
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
