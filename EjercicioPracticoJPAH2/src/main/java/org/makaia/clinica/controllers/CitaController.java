package org.makaia.clinica.controllers;

import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CitaController {
    CitaService service;

    @Autowired
    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping("/odontologo/{matricula}/paciente/{dni}/fecha/{fecha}/asignar")
    public ResponseEntity asignar(@PathVariable("matricula") Integer matricula,
                                       @PathVariable("dni") Integer dni,
                                       @PathVariable("fecha") String fecha) throws ApiException {
        return ResponseEntity.ok(this.service.asignar(matricula, dni, fecha));
    }
}
