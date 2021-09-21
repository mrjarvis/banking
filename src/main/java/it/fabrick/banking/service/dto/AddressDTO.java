package it.fabrick.banking.service.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    private String address;

    private String city;

    private String countryCode;

    public AddressDTO() { }

    public AddressDTO(String address, String city, String countryCode) {
        this.address = address;
        this.city = city;
        this.countryCode = countryCode;
    }

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getCountryCode() {return countryCode;}

    public void setCountryCode(String countryCode) {this.countryCode = countryCode;}

}
