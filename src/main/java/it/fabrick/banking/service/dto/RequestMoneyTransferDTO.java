package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class RequestMoneyTransferDTO implements Serializable {

    private static final long serialVersionUID = -1977265389579343903L;

    @JsonProperty(required = true)
    private CreditorDTO creditor;

    private String executionDate;

    private String uri;

    @JsonProperty(required = true)
    private String description;

    @JsonProperty(value = "amount", required = true)
    private Number amount;

    @JsonProperty(required = true)
    private String currency;

    private Boolean isUrgent;

    private Boolean isInstant;

    private String feeType;

    private String feeAccountId;

    private TaxReliefDTO taxRelief;

    public RequestMoneyTransferDTO() { }

    public RequestMoneyTransferDTO(CreditorDTO creditor, String executionDate, String uri, String description, Number amount, String currency, Boolean isUrgent, Boolean isInstant, String feeType, String feeAccountId, TaxReliefDTO taxRelief) {
        this.creditor = creditor;
        this.executionDate = executionDate;
        this.uri = uri;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.isUrgent = isUrgent;
        this.isInstant = isInstant;
        this.feeType = feeType;
        this.feeAccountId = feeAccountId;
        this.taxRelief = taxRelief;
    }

    public CreditorDTO getCreditor() {return creditor;}

    public void setCreditor(CreditorDTO creditor) {this.creditor = creditor;}

    public String getExecutionDate() {return executionDate;}

    public void setExecutionDate(String executionDate) {this.executionDate = executionDate;}

    public String getUri() {return uri;}

    public void setUri(String uri) {this.uri = uri;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Number getAmount() {return amount;}

    public void setAmount(Number amount) {this.amount = amount;}

    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}

    public Boolean getUrgent() {return isUrgent;}

    public void setUrgent(Boolean urgent) {isUrgent = urgent;}

    public Boolean getInstant() {return isInstant;}

    public void setInstant(Boolean instant) {isInstant = instant;}

    public String getFeeType() {return feeType;}

    public void setFeeType(String feeType) {this.feeType = feeType;}

    public String getFeeAccountId() {return feeAccountId;}

    public void setFeeAccountId(String feeAccountId) {this.feeAccountId = feeAccountId;}

    public TaxReliefDTO getTaxRelief() {return taxRelief;}

    public void setTaxRelief(TaxReliefDTO taxRelief) {this.taxRelief = taxRelief;}

}
