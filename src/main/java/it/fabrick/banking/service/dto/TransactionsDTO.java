package it.fabrick.banking.service.dto;

import java.io.Serializable;
import java.util.List;

public class TransactionsDTO implements Serializable {

    private static final long serialVersionUID = -8651969813669176982L;

    private List<TransactionDTO> list;

    public TransactionsDTO() { }

    public TransactionsDTO(List<TransactionDTO> list) {
        this.list = list;
    }

    public List<TransactionDTO> getList() {return list;}

    public void setList(List<TransactionDTO> list) {this.list = list;}

}
