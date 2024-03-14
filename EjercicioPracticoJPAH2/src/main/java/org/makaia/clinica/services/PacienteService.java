package org.makaia.clinica.services;

import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.models.Paciente;
import org.makaia.clinica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente crear(Paciente paciente) {
        if (paciente == null){
            throw new ApiException(400, "el paciente es nulo");
        }
        if(paciente.getDni() == null || paciente.getApellido() == null
                || paciente.getNombre() == null){
            throw new ApiException(400, "La información correspondiente al " +
                    "nombre, apellido y dni del paciente no pueden " +
                    "ser nulos");
        }
        if(repository.existsById(paciente.getDni())){
            throw new ApiException(400,
                    "El paciente con dni '" + paciente.getDni() +
                            "' ya existe en la base de datos.");
        }
        return this.repository.save(paciente);
    }

    public ResponseEntity eliminar(Integer dni) {
        if(!repository.existsById(dni)){
            throw new ApiException(400,
                    "El paciente con dni '" + dni +
                            "' no existe en la base de datos.");
        }
        this.repository.deleteById(dni);
        return ResponseEntity.ok("Paciente con dni '" + dni +
                "' eliminado.");
    }

    public Iterable<Paciente> obtener() {
        Iterable<Paciente> pacientes = this.repository.findAll();
        if(this.repository.count() == 0){
            throw new ApiException(200, "La lista de pacientes está vacía");
        }
        return pacientes;
    }
}
