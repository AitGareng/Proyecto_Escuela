package es.aitor.colegio.colegio_backend.mapper;

import es.aitor.colegio.colegio_backend.dto.LegalGuardianDTO;
import es.aitor.colegio.colegio_backend.model.LegalGuardian;

public class LegalGuardianMapper {

    public static LegalGuardianDTO toDTO(LegalGuardian legalGuardian){
    LegalGuardianDTO dto = new LegalGuardianDTO();

        dto.setId(legalGuardian.getId());
        dto.setName(legalGuardian.getName());
        dto.setSurname(legalGuardian.getSurname());
        dto.setPhone(legalGuardian.getPhone());
        dto.setEmail(legalGuardian.getEmail());

        return dto;
    }

    
}
