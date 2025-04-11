package cirulink.controllers;


import cirulink.models.PacienteModel;
import cirulink.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:3000")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping("/getAllPatients")
    public List<PacienteModel> getAllPatients(){
        return service.getAllPatients();

    }

    @PostMapping("/savePatient")
    public PacienteModel guardarCliente(@RequestBody PacienteModel paciente) {
        return service.savePatient(paciente);
    }

    @PutMapping("/updatePatient")
    public ResponseEntity<PacienteModel> updatePatient(@PathVariable Long id,
                                                       @RequestBody PacienteModel pacienteRequest){
        return service.updatePatient(id, pacienteRequest);
    }

    @DeleteMapping("/deletePatient")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        return service.deletePatient(id);
    }

}
