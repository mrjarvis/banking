package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TransactionDTO implements Serializable {

    private static final long serialVersionUID = -1771786361515806832L;

    private String transactionId;

    private String operationId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date accountingDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date valueDate;

    private Number amount;

    private String currency;

    private String description;

    public TransactionDTO() { }

    public TransactionDTO(String transactionId, String operationId, Date accountingDate, Date valueDate, Number amount, String currency, String description) {
        this.transactionId = transactionId;
        this.operationId = operationId;
        this.accountingDate = accountingDate;
        this.valueDate = valueDate;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {this.currency = currency;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

}
