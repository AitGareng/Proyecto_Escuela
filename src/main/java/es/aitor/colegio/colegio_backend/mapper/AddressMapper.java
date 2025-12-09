package es.aitor.colegio.colegio_backend.mapper;

import es.aitor.colegio.colegio_backend.dto.AddressDTO;
import es.aitor.colegio.colegio_backend.model.Address;

public class AddressMapper {

    public static AddressDTO toDTO(Address address){
        AddressDTO dto = new AddressDTO();

        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setPostalCode(address.getPostalCode());
        dto.setProvince(address.getProvince());
        dto.setCountry(address.getCountry());

        return dto;
    }

    
    
}
