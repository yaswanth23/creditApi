package com.crdt.creditapi.services;

import com.crdt.creditapi.dto.AccountCreateResDto;
import com.crdt.creditapi.dto.AccountDto;
import com.crdt.creditapi.dto.CreditCreateResDto;
import com.crdt.creditapi.dto.CreditLimitOfferDto;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import com.crdt.creditapi.utilities.WebServiceException;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCore {
    AccountCreateResDto createCustomerAccount(AccountRequest accountRequest);

    AccountDto getAccountDetails(Long account_id) throws WebServiceException;

    CreditCreateResDto createLimitOffer(CreditLimitOfferRequest creditLimitOfferRequest) throws WebServiceException;
}
