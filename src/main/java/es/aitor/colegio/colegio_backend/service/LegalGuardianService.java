package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.LegalGuardianDTO;
import es.aitor.colegio.colegio_backend.mapper.LegalGuardianMapper;
import es.aitor.colegio.colegio_backend.model.LegalGuardian;
import es.aitor.colegio.colegio_backend.repository.LegalGuardianRepository;

@Service

public class LegalGuardianService {

    @Autowired
    public LegalGuardianRepository legalGuardianRepository;

    //GET obtener todos lo tutores de menores por DTO
    public List<LegalGuardianDTO> getAllLegalGuardiansByDto(){
        return legalGuardianRepository.findAll()
            .stream()
            .map(LegalGuardianMapper::toDTO)
            .toList();
    }

    // GET
    public List<LegalGuardian> getAllLegalGuardians() {
        return legalGuardianRepository.findAll();
    }

    // POST
    public LegalGuardian createLegalGuardian(LegalGuardian legalGuardian) {
        return legalGuardianRepository.save(legalGuardian);

    }

    // PUT
    public LegalGuardian updateLegalGuardian(long id, LegalGuardian legalGuardian) {
        LegalGuardian legalGuardianExisting = legalGuardianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor legal con id " + id + ", no encontrado"));
        legalGuardianExisting.setName(legalGuardian.getName());
        legalGuardianExisting.setSurname(legalGuardian.getSurname());
        legalGuardianExisting.setPhone(legalGuardian.getPhone());
        legalGuardianExisting.setEmail(legalGuardian.getEmail());
        legalGuardianExisting.setRelationship(legalGuardian.getRelationship());
        //legalGuardianExisting.setStudent(legalGuardian.getStudent());
        return legalGuardianRepository.save(legalGuardianExisting);
    }

    // DELETE
    public void deleteLegalGuardian(long id, LegalGuardian legalGuardian) {
        legalGuardianRepository.deleteById(id);
    }

}
