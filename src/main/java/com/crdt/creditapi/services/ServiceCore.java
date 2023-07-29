package com.crdt.creditapi.services;

import com.crdt.creditapi.dto.*;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import com.crdt.creditapi.requests.UpdateCreditLimitRequest;
import com.crdt.creditapi.utilities.WebServiceException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ServiceCore {
    AccountCreateResDto createCustomerAccount(AccountRequest accountRequest);

    AccountDto getAccountDetails(Long account_id) throws WebServiceException;

    CreditCreateResDto createLimitOffer(CreditLimitOfferRequest creditLimitOfferRequest) throws WebServiceException;

    List<LimitOfferDto> getLimitOffers(Long account_id, LocalDateTime activeDate) throws WebServiceException;

    UpdateCreditLimitResDto updateCreditLimit(Long limitOfferId, UpdateCreditLimitRequest updateCreditLimitRequest) throws WebServiceException;
}
