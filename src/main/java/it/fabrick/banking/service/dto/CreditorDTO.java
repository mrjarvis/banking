package it.fabrick.banking.service.dto;

public class CreditorDTO extends PersonDTO {

    private static final long serialVersionUID = 617210739814371615L;

    private AddressDTO address;

    public CreditorDTO() { }

    public CreditorDTO(AddressDTO address) {
        this.address = address;
    }

    public AddressDTO getAddress() {return address;}

    public void setAddress(AddressDTO address) {this.address = address;}

}
