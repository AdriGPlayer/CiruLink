package cirulink.services;

import cirulink.models.PacienteModel;
import cirulink.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteModel> getAllPatients(){
        return repository.findAll();
    }

    public PacienteModel savePatient (PacienteModel paciente){
        return repository.save(paciente);
    }

    public ResponseEntity<PacienteModel> updatePatient(Long id,
                                                       PacienteModel pacienteRequest){
        Optional<PacienteModel> pacienteOptional = repository.findById(id);
        if(!pacienteOptional.isPresent())
            return ResponseEntity.notFound().build();
        else{
            PacienteModel paciente = pacienteOptional.get();

            paciente.setNombre(pacienteRequest.getNombre());
            paciente.setApellido(pacienteRequest.getApellido());
            paciente.setPeso(pacienteRequest.getPeso());
            paciente.setEdad(pacienteRequest.getEdad());
            paciente.setSexo(pacienteRequest.getSexo());
            paciente.setAseguradora(pacienteRequest.getAseguradora());
            paciente.setVpo(pacienteRequest.isVpo());

            PacienteModel pacienteActualizado = repository.save(paciente);

            return ResponseEntity.ok(pacienteActualizado);

        }

    }


    public ResponseEntity<Void> deletePatient(Long id){
        Optional<PacienteModel> pacienteOptional = repository.findById(id);
        if(!pacienteOptional.isPresent())
            return ResponseEntity.notFound().build();
        else{
            repository.deleteById(id);
            return ResponseEntity.noContent().build();

        }
    }




}
