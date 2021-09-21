package it.fabrick.banking.service.dto;

import java.io.Serializable;
import java.util.List;

public class GenericResponseDTO implements Serializable {

    private static final long serialVersionUID = -4585426517939019981L;

    private String status;

    private List<String> error;

    public GenericResponseDTO() { }

    public GenericResponseDTO(String status, List<String> error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public List<String> getError() {return error;}

    public void setError(List<String> error) {this.error = error;}

}
