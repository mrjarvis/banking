package it.fabrick.banking.service.dto;

import java.io.Serializable;
import java.util.List;

public class AccountTransactionsResponseDTO extends GenericResponseDTO implements Serializable {

    private static final long serialVersionUID = -4548047602179178592L;

    private TransactionsDTO payload;

    public AccountTransactionsResponseDTO() { }

    public AccountTransactionsResponseDTO(TransactionsDTO payload) {
        this.payload = payload;
    }

    public AccountTransactionsResponseDTO(String status, List<String> error) {
        super(status, error);
    }

    public TransactionsDTO getPayload() {return payload;}

    public void setPayload(TransactionsDTO payload) {this.payload = payload;}

}
