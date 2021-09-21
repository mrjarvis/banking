package it.fabrick.banking.service.impl;

import it.fabrick.banking.config.BankingServiceProperties;
import it.fabrick.banking.service.FabrickBankingService;
import it.fabrick.banking.service.dto.AccountTransactionsResponseDTO;
import it.fabrick.banking.service.dto.BalanceResponseDTO;
import it.fabrick.banking.service.dto.MTResponseDTO;
import it.fabrick.banking.service.dto.RequestMoneyTransferDTO;
import it.fabrick.banking.web.rest.RestTemplateResponseErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.ClientErrorException;
import java.util.Collections;

@Service
public class FabrickBankingServiceImpl implements FabrickBankingService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final BankingServiceProperties bankingServiceProperties;

    private final RestTemplate restTemplate;

    public FabrickBankingServiceImpl(BankingServiceProperties bankingServiceProperties, RestTemplateBuilder restTemplateBuilder) {
        this.bankingServiceProperties = bankingServiceProperties;
        this.restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
    }

    @Override
    public ResponseEntity<BalanceResponseDTO> getAccountBalance(String accountId) {
        log.debug("getAccountBalance START");
        try {
            String requestUri = bankingServiceProperties.getBaseUri().concat(bankingServiceProperties.getAccountBalanceUri());
            HttpHeaders headers = createAuthRequestHeaders();
            ResponseEntity<BalanceResponseDTO> response = restTemplate.exchange(requestUri, HttpMethod.GET, new HttpEntity<>(headers), BalanceResponseDTO.class, accountId);
            log.debug("getAccountBalance END");
            return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
        } catch (ClientErrorException ex) {
            return ResponseEntity.status(ex.getResponse().getStatus()).body(null);
        } catch (RestClientException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<MTResponseDTO> createMoneyTransfer(String accountId, String timeZone, RequestMoneyTransferDTO requestMoneyTransferDTO) {
        log.debug("createMoneyTransfer START");
        try {
            String requestUri = bankingServiceProperties.getBaseUri().concat(bankingServiceProperties.getMoneyTransferUri());
            HttpHeaders headers = createAuthRequestHeaders();
            headers.add("X-Time-Zone", timeZone);
            ResponseEntity<MTResponseDTO> response = restTemplate.exchange(requestUri, HttpMethod.POST, new HttpEntity<>(requestMoneyTransferDTO, headers), MTResponseDTO.class, accountId);
            log.debug("createMoneyTransfer END");
            return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
        } catch (ClientErrorException ex) {
            return ResponseEntity.status(ex.getResponse().getStatus()).body(null);
        } catch (RestClientException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<AccountTransactionsResponseDTO> getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate) {
        log.debug("getAccountTransactions START");
        try {
            String requestUri = bankingServiceProperties.getBaseUri().concat(bankingServiceProperties.getAccountTransactions());
            HttpHeaders headers = createAuthRequestHeaders();
            ResponseEntity<AccountTransactionsResponseDTO> response = restTemplate.exchange(requestUri, HttpMethod.GET, new HttpEntity<>(headers),
                    AccountTransactionsResponseDTO.class, accountId, fromAccountingDate, toAccountingDate);
            log.debug("getAccountTransactions END");
            return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
        } catch (ClientErrorException ex) {
            return ResponseEntity.status(ex.getResponse().getStatus()).body(null);
        } catch (RestClientException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private HttpHeaders createAuthRequestHeaders() {
        log.debug("createAuthRequestHeaders START");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Auth-Schema", bankingServiceProperties.getAuthSchema());
        headers.add("Api-Key", bankingServiceProperties.getKey());
        log.debug("createAuthRequestHeaders END");
        return headers;
    }

}
