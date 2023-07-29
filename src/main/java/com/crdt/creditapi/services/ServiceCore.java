package com.crdt.creditapi.services;

import com.crdt.creditapi.dto.AccountCreateResDto;
import com.crdt.creditapi.dto.AccountDto;
import com.crdt.creditapi.dto.CreditLimitOfferDto;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCore {
    AccountCreateResDto createCustomerAccount(AccountRequest accountRequest);

    AccountDto getAccountDetails(Long account_id);

    CreditLimitOfferDto createLimitOffer(CreditLimitOfferRequest creditLimitOfferRequest);
}
