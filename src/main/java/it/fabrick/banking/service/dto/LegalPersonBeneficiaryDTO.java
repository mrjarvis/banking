package it.fabrick.banking.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class LegalPersonBeneficiaryDTO implements Serializable {

    private static final long serialVersionUID = 8073879582351745395L;

    @JsonProperty(required = true)
    private String fiscalCode;

    private String legalRepresentativeFiscalCode;

    public LegalPersonBeneficiaryDTO() { }

    public LegalPersonBeneficiaryDTO(String fiscalCode, String legalRepresentativeFiscalCode) {
        this.fiscalCode = fiscalCode;
        this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
    }

    public String getFiscalCode() {return fiscalCode;}

    public void setFiscalCode(String fiscalCode) {this.fiscalCode = fiscalCode;}

    public String getLegalRepresentativeFiscalCode() {return legalRepresentativeFiscalCode;}

    public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;}

}
