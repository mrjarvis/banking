package it.fabrick.banking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fabrick.api")
public class BankingServiceProperties {

    private String authSchema;

    private String key;

    private String baseUri;

    private String accountBalanceUri;

    private String moneyTransferUri;

    private String accountTransactions;

    public String getAuthSchema() {return authSchema;}

    public void setAuthSchema(String authSchema) {this.authSchema = authSchema;}

    public String getKey() {return key;}

    public void setKey(String key) {this.key = key;}

    public String getBaseUri() {return baseUri;}

    public void setBaseUri(String baseUri) {this.baseUri = baseUri;}

    public String getAccountBalanceUri() {return accountBalanceUri;}

    public void setAccountBalanceUri(String accountBalanceUri) {this.accountBalanceUri = accountBalanceUri;}

    public String getMoneyTransferUri() {return moneyTransferUri;}

    public void setMoneyTransferUri(String moneyTransferUri) {this.moneyTransferUri = moneyTransferUri;}

    public String getAccountTransactions() {return accountTransactions;}

    public void setAccountTransactions(String accountTransactions) {this.accountTransactions = accountTransactions;}

}
