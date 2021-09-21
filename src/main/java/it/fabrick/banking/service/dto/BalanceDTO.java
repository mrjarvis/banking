package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BalanceDTO implements Serializable {

    private static final long serialVersionUID = 5995524876872377310L;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Number balance;

    private Number availableBalance;

    private String currency;

    public BalanceDTO() { }

    public BalanceDTO(Date date, Number balance, Number availableBalance, String currency) {
        this.date = date;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.currency = currency;
    }

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public Number getBalance() {return balance;}

    public void setBalance(Number balance) {this.balance = balance;}

    public Number getAvailableBalance() {return availableBalance;}

    public void setAvailableBalance(Number availableBalance) {this.availableBalance = availableBalance;}

    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}

}
