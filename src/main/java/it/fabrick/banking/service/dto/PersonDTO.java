package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PersonDTO implements Serializable {

    private static final long serialVersionUID = -505376023166544482L;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private AccountDTO account;

    public PersonDTO() { }

    public PersonDTO(String name, AccountDTO account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public AccountDTO getAccount() {return account;}

    public void setAccount(AccountDTO account) {this.account = account;}

}
