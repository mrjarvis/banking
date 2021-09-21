package it.fabrick.banking.web.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.fabrick.banking.BankingApplication;
import it.fabrick.banking.TestUtil;
import it.fabrick.banking.service.dto.*;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest(classes = BankingApplication.class)
public class BankingResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAccountBalance() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/{accountId}/balance", "14537780"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testCreateMoneyTransfer() throws Exception {

        RequestMoneyTransferDTO moneyTransfer = new RequestMoneyTransferDTO();
        CreditorDTO creditor = new CreditorDTO();
        creditor.setName("John Doe");
        AccountDTO account = new AccountDTO();
        account.setAccountCode("IT23A0336844430152923804660");
        account.setBicCode("SELBIT2BXXX");
        moneyTransfer.setExecutionDate("2019-04-01");
        moneyTransfer.setDescription("Payment invoice 75/2017");
        moneyTransfer.setAmount(800);
        moneyTransfer.setCurrency("EUR");
        moneyTransfer.setFeeType("SHA");
        moneyTransfer.setFeeAccountId("45685475");
        TaxReliefDTO taxRelief = new TaxReliefDTO();
        taxRelief.setTaxReliefId("L449");
        taxRelief.setCreditorFiscalCode("56258745832");
        taxRelief.setBeneficiaryType("NATURAL_PERSON");
        NaturalPersonBeneficiaryDTO naturalPersonBeneficiary = new NaturalPersonBeneficiaryDTO();
        naturalPersonBeneficiary.setFiscalCode1("MRLFNC81L04A859L");

        creditor.setAccount(account);
        taxRelief.setNaturalPersonBeneficiary(naturalPersonBeneficiary);
        moneyTransfer.setCreditor(creditor);
        moneyTransfer.setTaxRelief(taxRelief);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/accounts/{accountId}/payments/money-transfers", "14537780")
                        .header("X-Time-Zone", "Europe/Rome")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(moneyTransfer)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void testGetAccountTransactions() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/{accountId}/transactions?fromAccountingDate={fromAccountingDate}&toAccountingDate={toAccountingDate}",
                        "14537780", "2019-04-01", "2019-12-01"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();

        AccountTransactionsResponseDTO actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<AccountTransactionsResponseDTO>() {});

        Assertions.assertThat(!actual.getPayload().getList().isEmpty());

    }

}
