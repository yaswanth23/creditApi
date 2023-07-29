package com.crdt.creditapi.services;

import com.crdt.creditapi.dto.AccountDto;
import com.crdt.creditapi.dto.CreditLimitOfferDto;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCore {
    CreditLimitOfferDto createLimitOffer(CreditLimitOfferRequest creditLimitOfferRequest);

    AccountDto createCustomerAccount(AccountRequest accountRequest);
}
