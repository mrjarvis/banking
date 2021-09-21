package it.fabrick.banking.service.dto;

import java.io.Serializable;
import java.util.List;

public class BalanceResponseDTO extends GenericResponseDTO implements Serializable {

    private static final long serialVersionUID = 686204921831887022L;

    private BalanceDTO payload;

    public BalanceResponseDTO() { }

    public BalanceResponseDTO(BalanceDTO payload) {
        this.payload = payload;
    }

    public BalanceResponseDTO(String status, List<String> error) {
        super(status, error);
    }

    public BalanceDTO getPayload() {return payload;}

    public void setPayload(BalanceDTO payload) {this.payload = payload;}

}
