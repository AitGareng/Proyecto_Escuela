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

import es.aitor.colegio.colegio_backend.dto.LegalGuardianDTO;
import es.aitor.colegio.colegio_backend.model.LegalGuardian;
import es.aitor.colegio.colegio_backend.service.LegalGuardianService;

@RestController
@RequestMapping("/guardian")
public class LegalGuardianController {

    @Autowired
    public LegalGuardianService legalGuardianService;

    @GetMapping("/dto")
    public List<LegalGuardianDTO> getAllLegalGuardianByDto(){
        return legalGuardianService.getAllLegalGuardiansByDto();
    }

    @GetMapping
    public List<LegalGuardian> getAllLegalGuardia() {
        List<LegalGuardian> legalGuardians = legalGuardianService.getAllLegalGuardians();
        return legalGuardians;
    }

    @PostMapping
    public LegalGuardian createLegalGuardian(@RequestBody LegalGuardian legalGuardian) {
        LegalGuardian legalGuardianSaved = legalGuardianService.createLegalGuardian(legalGuardian);
        return legalGuardianSaved;
    }

    @PutMapping("/{id}")
    public LegalGuardian updateLegalGuardian(@PathVariable Long id, @RequestBody LegalGuardian legalGuardian) {
        return legalGuardianService.updateLegalGuardian(id, legalGuardian);

    }

    @DeleteMapping("/{id}")
    public String deleteGuardian(@PathVariable Long id) {
        return "El tutor legal con id " + id + ", fue eliminado correctamente";
    }

}
