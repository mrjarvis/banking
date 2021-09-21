package it.fabrick.banking.service.dto;

import java.io.Serializable;
import java.util.List;

public class MTResponseDTO extends GenericResponseDTO implements Serializable {

    private static final long serialVersionUID = 6660901925946774915L;

    private ResponseMoneyTransferDTO payload;

    public MTResponseDTO() { }

    public MTResponseDTO(ResponseMoneyTransferDTO payload) {
        this.payload = payload;
    }

    public MTResponseDTO(String status, List<String> error) {
        super(status, error);
    }

    public ResponseMoneyTransferDTO getPayload() {return payload;}

    public void setPayload(ResponseMoneyTransferDTO payload) {this.payload = payload;}

}
