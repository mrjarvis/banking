package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TaxReliefDTO implements Serializable {

    private static final long serialVersionUID = 1387575388613681436L;

    private String taxReliefId;

    @JsonProperty(required = true)
    private Boolean isCondoUpgrade;

    @JsonProperty(required = true)
    private String creditorFiscalCode;

    @JsonProperty(required = true)
    private String beneficiaryType;

    private NaturalPersonBeneficiaryDTO naturalPersonBeneficiary;

    private LegalPersonBeneficiaryDTO legalPersonBeneficiary;

    public TaxReliefDTO() { }

    public TaxReliefDTO(String taxReliefId, Boolean isCondoUpgrade, String creditorFiscalCode, String beneficiaryType, NaturalPersonBeneficiaryDTO naturalPersonBeneficiary, LegalPersonBeneficiaryDTO legalPersonBeneficiary) {
        this.taxReliefId = taxReliefId;
        this.isCondoUpgrade = isCondoUpgrade;
        this.creditorFiscalCode = creditorFiscalCode;
        this.beneficiaryType = beneficiaryType;
        this.naturalPersonBeneficiary = naturalPersonBeneficiary;
        this.legalPersonBeneficiary = legalPersonBeneficiary;
    }

    public String getTaxReliefId() {return taxReliefId;}

    public void setTaxReliefId(String taxReliefId) {this.taxReliefId = taxReliefId;}

    public Boolean getCondoUpgrade() {return isCondoUpgrade;}

    public void setCondoUpgrade(Boolean condoUpgrade) {isCondoUpgrade = condoUpgrade;}

    public String getCreditorFiscalCode() {return creditorFiscalCode;}

    public void setCreditorFiscalCode(String creditorFiscalCode) {this.creditorFiscalCode = creditorFiscalCode;}

    public String getBeneficiaryType() {return beneficiaryType;}

    public void setBeneficiaryType(String beneficiaryType) {this.beneficiaryType = beneficiaryType;}

    public NaturalPersonBeneficiaryDTO getNaturalPersonBeneficiary() {return naturalPersonBeneficiary;}

    public void setNaturalPersonBeneficiary(NaturalPersonBeneficiaryDTO naturalPersonBeneficiary) {this.naturalPersonBeneficiary = naturalPersonBeneficiary;}

    public LegalPersonBeneficiaryDTO getLegalPersonBeneficiary() {return legalPersonBeneficiary;}

    public void setLegalPersonBeneficiary(LegalPersonBeneficiaryDTO legalPersonBeneficiary) {this.legalPersonBeneficiary = legalPersonBeneficiary;}

}
