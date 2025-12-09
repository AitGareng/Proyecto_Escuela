package es.aitor.colegio.colegio_backend.dto;

import lombok.Data;

@Data
public class AddressDTO {

    public Long id;
    public String street;
    public String city;
    public String postalCode;
    public String province;
    public String country;


    
}
