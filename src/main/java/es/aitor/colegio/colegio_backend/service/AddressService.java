package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.AddressDTO;
import es.aitor.colegio.colegio_backend.mapper.AddressMapper;
import es.aitor.colegio.colegio_backend.model.Address;
import es.aitor.colegio.colegio_backend.repository.AddressRepository;

@Service

public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    //GET obtener todas la direcciones mediante DTO
    public List<AddressDTO> getAllAddressByDto(){
        return addressRepository.findAll()
            .stream()
            .map(AddressMapper::toDTO)
            .toList();
    }

    //GET
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    //POST
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    //PUT
    public Address updateAddress(long id, Address address){
        Address addressExisting = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Direccion con id " + id + ", no encontrada"));
        addressExisting.setStreet(address.getStreet());
        addressExisting.setCity(address.getCity());
        addressExisting.setPostalCode(address.getPostalCode());
        addressExisting.setProvince(address.getProvince());
        addressExisting.setCountry(address.getCountry());
        return addressRepository.save(addressExisting);
    }

    //DELETE
    public void deleteAddress(long id){
        addressRepository.deleteById(id);
    }


    

    
}
