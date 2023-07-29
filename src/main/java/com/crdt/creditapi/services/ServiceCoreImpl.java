package com.crdt.creditapi.services;

import com.crdt.creditapi.constants.CommonConstants;
import com.crdt.creditapi.constants.ErrorConstants;
import com.crdt.creditapi.dto.AccountCreateResDto;
import com.crdt.creditapi.dto.AccountDto;
import com.crdt.creditapi.dto.CreditCreateResDto;
import com.crdt.creditapi.dto.LimitOfferDto;
import com.crdt.creditapi.entities.AccountsEntity;
import com.crdt.creditapi.entities.LimitOfferEntity;
import com.crdt.creditapi.repositories.AccountRepository;
import com.crdt.creditapi.repositories.LimitOfferRepository;
import com.crdt.creditapi.requests.AccountRequest;
import com.crdt.creditapi.requests.CreditLimitOfferRequest;
import com.crdt.creditapi.utilities.WebServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceCoreImpl implements ServiceCore {
    private static final Logger logger = LogManager.getLogger(ServiceCoreImpl.class);

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    LimitOfferRepository limitOfferRepository;

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
    public AccountDto getAccountDetails(Long account_id) throws WebServiceException {
        try {
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
                throw new WebServiceException(ErrorConstants.ERROR_STATUS_CODE_404, ErrorConstants.ERROR_STATUS_CODE_404_MESSAGE);
            }
            logger.info("get account details response: {}", response.toString());
            return response;
        } catch (WebServiceException e) {
            logger.error(e);
            throw e;
        }
    }

    @Override
    public CreditCreateResDto createLimitOffer(CreditLimitOfferRequest creditLimitOfferRequest) throws WebServiceException {
        try {
            logger.info("Inside create limit offer: {}", creditLimitOfferRequest);
            CreditCreateResDto response = new CreditCreateResDto();
            AccountsEntity accountsDetails = accountRepository.findByAccountId(creditLimitOfferRequest.getAccountId());

            if (accountsDetails == null) {
                throw new WebServiceException(ErrorConstants.ERROR_STATUS_CODE_404, ErrorConstants.ERROR_STATUS_CODE_404_MESSAGE);
            }

            LimitOfferEntity insertLimitOffer = getLimitOfferEntity(creditLimitOfferRequest, accountsDetails);

            limitOfferRepository.saveAndFlush(insertLimitOffer);

            Long limit_offer_id = insertLimitOffer.getLimitOfferId();

            response.setStatusCode(CommonConstants.STATUS_CODE_200);
            response.setStatusMessage(CommonConstants.ACCOUNT_CREATED_STATUS_CODE_MESSAGE);
            response.setLimit_offer_id(limit_offer_id);
            logger.info("create limit offer response: {}", response.toString());
            return response;
        } catch (WebServiceException e) {
            logger.error(e);
            throw e;
        }
    }

    @Override
    public List<LimitOfferDto> getLimitOffers(Long account_id, LocalDateTime activeDate) throws WebServiceException {
        try {
            logger.info("Inside get limit offers: accountId={}, activeDate={}", account_id, activeDate);
            List<LimitOfferDto> response = new ArrayList<>();
            AccountsEntity accountsDetails = accountRepository.findByAccountId(account_id);

            if (accountsDetails == null) {
                throw new WebServiceException(ErrorConstants.ERROR_STATUS_CODE_404, ErrorConstants.ERROR_STATUS_CODE_404_MESSAGE);
            }

            List<LimitOfferEntity> limitOffers = null;

            if (activeDate != null) {
                limitOffers = limitOfferRepository.findByAccountIdAndStatusAndOfferActivationTimeBeforeAndOfferExpiryTimeAfter(
                        account_id, "PENDING", activeDate, activeDate);
            } else {
                limitOffers = limitOfferRepository.findByAccountIdAndStatus(account_id, "PENDING");
            }

            for (LimitOfferEntity offerEntity : limitOffers) {
                LimitOfferDto offerDto = new LimitOfferDto();
                offerDto.setLimit_offer_id(offerEntity.getLimitOfferId());
                offerDto.setAccount_id(offerEntity.getAccountId());
                offerDto.setLimit_type(offerEntity.getLimitType());
                offerDto.setNew_limit(offerEntity.getNewLimit());
                offerDto.setOffer_activation_time(offerEntity.getOfferActivationTime());
                offerDto.setOffer_expiry_time(offerEntity.getOfferExpiryTime());
                offerDto.setStatus(offerEntity.getStatus());

                response.add(offerDto);
            }
            logger.info("get limit offer response: {}", response.toString());
            return response;
        } catch (WebServiceException e) {
            logger.error(e);
            throw e;
        }
    }

    private static LimitOfferEntity getLimitOfferEntity(CreditLimitOfferRequest creditLimitOfferRequest, AccountsEntity accountsDetails) {
        LimitOfferEntity insertLimitOffer = new LimitOfferEntity();
        insertLimitOffer.setAccountId(accountsDetails.getAccountId());
        insertLimitOffer.setLimitType(String.valueOf(creditLimitOfferRequest.getLimitType()));
        insertLimitOffer.setNewLimit(creditLimitOfferRequest.getNewLimit());
        insertLimitOffer.setOfferActivationTime(creditLimitOfferRequest.getOfferActivationTime());
        insertLimitOffer.setOfferExpiryTime(creditLimitOfferRequest.getOfferExpiryTime());
        insertLimitOffer.setStatus("PENDING");
        return insertLimitOffer;
    }
}
