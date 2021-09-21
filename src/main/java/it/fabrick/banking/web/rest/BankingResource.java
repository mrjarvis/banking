package it.fabrick.banking.web.rest;

import it.fabrick.banking.service.FabrickBankingService;
import it.fabrick.banking.service.dto.AccountTransactionsResponseDTO;
import it.fabrick.banking.service.dto.BalanceResponseDTO;
import it.fabrick.banking.service.dto.MTResponseDTO;
import it.fabrick.banking.service.dto.RequestMoneyTransferDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class BankingResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final FabrickBankingService fabrickBankingService;

    public BankingResource(FabrickBankingService fabrickBankingService) {
        this.fabrickBankingService = fabrickBankingService;
    }

    /**
     *
     * @param accountId
     * @return
     */
    @GetMapping(path = "/accounts/{accountId}/balance")
    public ResponseEntity<BalanceResponseDTO> getAccountBalance(@PathVariable String accountId) {
        log.info("Account balance request START");
        ResponseEntity<BalanceResponseDTO> response = fabrickBankingService.getAccountBalance(accountId);
        return response;
    }

    /**
     *
     * @param timeZone
     * @param accountId
     * @param requestMoneyTransferDTO
     * @return
     */
    @PostMapping (path = "/accounts/{accountId}/payments/money-transfers")
    public ResponseEntity<MTResponseDTO> createMoneyTransfer(@RequestHeader(value = "X-Time-Zone") String timeZone,
                                                             @PathVariable String accountId,
                                                             @Valid @RequestBody RequestMoneyTransferDTO requestMoneyTransferDTO) {
        log.info("Create money transfer request START");
        ResponseEntity<MTResponseDTO> response = fabrickBankingService.createMoneyTransfer(accountId, timeZone, requestMoneyTransferDTO);
        return response;
    }

    /**
     *
     * @param accountId
     * @param fromAccountingDate
     * @param toAccountingDate
     * @return
     */
    @GetMapping (path = "/accounts/{accountId}/transactions")
    public ResponseEntity<AccountTransactionsResponseDTO> getAccountTransactions(@PathVariable String accountId,
                                       @RequestParam String fromAccountingDate,
                                       @RequestParam String toAccountingDate) {
        log.info("Get account transactions START");
        ResponseEntity<AccountTransactionsResponseDTO> response = fabrickBankingService.getAccountTransactions(accountId, fromAccountingDate, toAccountingDate);
        return response;
    }

}
