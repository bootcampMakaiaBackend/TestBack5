package org.makaia.clinica.services;

import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.models.Odontologo;
import org.makaia.clinica.repositories.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    OdontologoRepository repository;

    @Autowired
    public OdontologoService(OdontologoRepository repository) {
        this.repository = repository;
    }

    public Odontologo crear(Odontologo odontologo) throws ApiException {
        if(odontologo.getMatricula() == null || odontologo.getApellido() == null
                || odontologo.getNombre() == null){
            throw new ApiException(400, "La información correspondiente al " +
                    "nombre, apellido y matrícula del odontólogo no pueden " +
                    "ser nulos");
        }
        if(odontologo.getMatricula() <= 0 || odontologo.getApellido().isBlank()
                || odontologo.getNombre().isBlank()){
            throw new ApiException(400, "La información correspondiente al " +
                    "nombre, apellido y matrícula del odontólogo no puede " +
                    "estar vacía o ser menor que cero");
        }
        if(repository.existsById(odontologo.getMatricula())){
            throw new ApiException(400,
                    "El odontólogo con matrícula '" + odontologo.getMatricula() +
                            "' ya existe en la base de datos.");
        }
        return this.repository.save(odontologo);
    }

    public ResponseEntity eliminar(Integer matricula) throws ApiException {
        if(!repository.existsById(matricula)){
            throw new ApiException(400,
                    "El odontólogo con matrícula '" + matricula +
                            "' no existe en la base de datos.");
        }
        this.repository.deleteById(matricula);
        return ResponseEntity.ok("Odontólogo con matrícula '" + matricula +
                "' eliminado.");
    }

    public Iterable<Odontologo> obtener() throws ApiException {
        Iterable<Odontologo> odontologos = this.repository.findAll();
        if(this.repository.count() == 0){
            throw new ApiException(200, "La lista de odontólogos está vacía");
        }
        return odontologos;
    }
}
