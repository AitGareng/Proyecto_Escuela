package es.aitor.colegio.colegio_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.aitor.colegio.colegio_backend.dto.AddressDTO;
import es.aitor.colegio.colegio_backend.model.Address;
import es.aitor.colegio.colegio_backend.service.AddressService;

@RestController
@RequestMapping("/address")

public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/dto")
    public List<AddressDTO> getAllAddressByDto(){
        return addressService.getAllAddressByDto();
    }

    @GetMapping
    public List<Address> getAllAddress(){
    return addressService.getAllAddress();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable long id){
        addressService.deleteAddress(id);
        return "Direccion eliminada correctamente";

    }



    
}
