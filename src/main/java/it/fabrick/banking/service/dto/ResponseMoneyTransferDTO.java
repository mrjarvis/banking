package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ResponseMoneyTransferDTO implements Serializable {

    private static final long serialVersionUID = 8500237728725926346L;

    private String moneyTransferId;

    private String status;

    private String direction;

    private CreditorDTO creditor;

    private DebtorDTO debtor;

    private String cro;

    private String trn;

    private String uri;

    private String description;

    private LocalDateTime createdDatetime;

    private LocalDateTime accountedDatetime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date debtorValueDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creditorValueDate;

    private Boolean isUrgent;

    private Boolean isInstant;

    private String feeType;

    private String feeAccountId;

    private List<FeeDTO> fees;

    private Boolean hasTaxRelief;

    public ResponseMoneyTransferDTO() { }

    public String getMoneyTransferId() {
        return moneyTransferId;
    }

    public void setMoneyTransferId(String moneyTransferId) {
        this.moneyTransferId = moneyTransferId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public CreditorDTO getCreditor() {
        return creditor;
    }

    public void setCreditor(CreditorDTO creditor) {
        this.creditor = creditor;
    }

    public DebtorDTO getDebtor() {
        return debtor;
    }

    public void setDebtor(DebtorDTO debtor) {
        this.debtor = debtor;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDateTime getAccountedDatetime() {
        return accountedDatetime;
    }

    public void setAccountedDatetime(LocalDateTime accountedDatetime) {
        this.accountedDatetime = accountedDatetime;
    }

    public Date getDebtorValueDate() {
        return debtorValueDate;
    }

    public void setDebtorValueDate(Date debtorValueDate) {
        this.debtorValueDate = debtorValueDate;
    }

    public Date getCreditorValueDate() {
        return creditorValueDate;
    }

    public void setCreditorValueDate(Date creditorValueDate) {
        this.creditorValueDate = creditorValueDate;
    }

    public Boolean getUrgent() {
        return isUrgent;
    }

    public void setUrgent(Boolean urgent) {
        isUrgent = urgent;
    }

    public Boolean getInstant() {
        return isInstant;
    }

    public void setInstant(Boolean instant) {
        isInstant = instant;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeAccountId() {
        return feeAccountId;
    }

    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public List<FeeDTO> getFees() {
        return fees;
    }

    public void setFees(List<FeeDTO> fees) {
        this.fees = fees;
    }

    public Boolean getHasTaxRelief() {
        return hasTaxRelief;
    }

    public void setHasTaxRelief(Boolean hasTaxRelief) {
        this.hasTaxRelief = hasTaxRelief;
    }

}
