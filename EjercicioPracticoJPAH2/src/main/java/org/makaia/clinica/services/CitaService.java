package org.makaia.clinica.services;

import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.models.Cita;
import org.makaia.clinica.models.Odontologo;
import org.makaia.clinica.models.Paciente;
import org.makaia.clinica.repositories.CitaRepository;
import org.makaia.clinica.repositories.OdontologoRepository;
import org.makaia.clinica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CitaService {
    CitaRepository citaRepository;
    PacienteRepository pacienteRepository;
    OdontologoRepository odontologoRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository,
                       PacienteRepository pacienteRepository,
                       OdontologoRepository odontologoRepository)
    {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
    }

    public Cita asignar(Integer matricula, Integer dni, String fecha) throws ApiException {

        Optional<Paciente> paciente = pacienteRepository.findById(dni);
        Optional<Odontologo> odontologo = odontologoRepository.findById(matricula);
        if(paciente.isPresent() && odontologo.isPresent()){
            Cita cita = new Cita(paciente.get(),odontologo.get(),
                    LocalDate.parse(fecha));
            return this.citaRepository.save(cita);
        }else{
            throw new ApiException(400, "El dni del paciente o la matrícula " +
                    "del odontólogo no se encuentran en la base de datos");
        }

    }
}
