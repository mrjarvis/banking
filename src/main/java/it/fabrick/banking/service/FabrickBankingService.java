package it.fabrick.banking.service;

import it.fabrick.banking.service.dto.AccountTransactionsResponseDTO;
import it.fabrick.banking.service.dto.BalanceResponseDTO;
import it.fabrick.banking.service.dto.MTResponseDTO;
import it.fabrick.banking.service.dto.RequestMoneyTransferDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface FabrickBankingService {

    ResponseEntity<BalanceResponseDTO> getAccountBalance(String accountId);

    ResponseEntity<MTResponseDTO> createMoneyTransfer(String accountId, String timeZone, RequestMoneyTransferDTO requestMoneyTransferDTO);

    ResponseEntity<AccountTransactionsResponseDTO> getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate);

}
