package org.makaia.clinica.controllers;

import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.models.Paciente;
import org.makaia.clinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/paciente")
public class PacienteController {
    PacienteService service;

    @Autowired
    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity crear(@RequestBody Paciente paciente) throws ApiException {
        return ResponseEntity.ok(this.service.crear(paciente));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity eliminar(@PathVariable("dni") Integer dni) throws ApiException {
        return this.service.eliminar(dni);
    }

    @GetMapping()
    public ResponseEntity obtener() throws ApiException {
        return ResponseEntity.ok(this.service.obtener());
    }
}
