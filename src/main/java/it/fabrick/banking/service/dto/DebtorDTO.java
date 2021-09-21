package it.fabrick.banking.service.dto;

public class DebtorDTO extends PersonDTO {

    private static final long serialVersionUID = 3824707962782980919L;

    public DebtorDTO() { }

    public DebtorDTO(String name, AccountDTO account) {
        super(name, account);
    }

}
