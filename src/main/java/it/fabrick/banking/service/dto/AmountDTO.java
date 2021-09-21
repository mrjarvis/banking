package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class AmountDTO implements Serializable {

    private static final long serialVersionUID = 2887769294933017967L;

    private Number debtorAmount;

    private String debtorCurrency;

    private Number creditorAmount;

    private String creditorCurrency;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creditorCurrencyDate;

    private Number exchangeRate;

    public AmountDTO() { }

    public AmountDTO(Number debtorAmount, String debtorCurrency, Number creditorAmount, String creditorCurrency, Date creditorCurrencyDate, Number exchangeRate) {
        this.debtorAmount = debtorAmount;
        this.debtorCurrency = debtorCurrency;
        this.creditorAmount = creditorAmount;
        this.creditorCurrency = creditorCurrency;
        this.creditorCurrencyDate = creditorCurrencyDate;
        this.exchangeRate = exchangeRate;
    }

    public Number getDebtorAmount() {return debtorAmount;}

    public void setDebtorAmount(Number debtorAmount) {this.debtorAmount = debtorAmount;}

    public String getDebtorCurrency() {return debtorCurrency;}

    public void setDebtorCurrency(String debtorCurrency) {this.debtorCurrency = debtorCurrency;}

    public Number getCreditorAmount() {return creditorAmount;}

    public void setCreditorAmount(Number creditorAmount) {this.creditorAmount = creditorAmount;}

    public String getCreditorCurrency() {return creditorCurrency;}

    public void setCreditorCurrency(String creditorCurrency) {this.creditorCurrency = creditorCurrency;}

    public Date getCreditorCurrencyDate() {return creditorCurrencyDate;}

    public void setCreditorCurrencyDate(Date creditorCurrencyDate) {this.creditorCurrencyDate = creditorCurrencyDate;}

    public Number getExchangeRate() {return exchangeRate;}

    public void setExchangeRate(Number exchangeRate) {this.exchangeRate = exchangeRate;}

}
