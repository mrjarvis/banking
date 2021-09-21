package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AccountDTO implements Serializable {

    private static final long serialVersionUID = -8553636140647773299L;

    @JsonProperty(required = true)
    private String accountCode;

    private String bicCode;

    public AccountDTO() { }

    public AccountDTO(String accountCode, String bicCode) {
        this.accountCode = accountCode;
        this.bicCode = bicCode;
    }

    public String getAccountCode() {return accountCode;}

    public void setAccountCode(String accountCode) {this.accountCode = accountCode;}

    public String getBicCode() {return bicCode;}

    public void setBicCode(String bicCode) {this.bicCode = bicCode;}

}
