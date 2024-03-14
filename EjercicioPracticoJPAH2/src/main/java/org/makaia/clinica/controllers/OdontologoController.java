package org.makaia.clinica.controllers;

import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.models.Odontologo;
import org.makaia.clinica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/odontologo")
public class OdontologoController {
    OdontologoService service;

    @Autowired
    public OdontologoController(OdontologoService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity crear(@RequestBody Odontologo odontologo) throws ApiException {
        return ResponseEntity.ok(this.service.crear(odontologo));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity eliminar(@PathVariable("matricula") Integer matricula) throws ApiException {
        return this.service.eliminar(matricula);
    }

    @GetMapping()
    public ResponseEntity obtener() throws ApiException {
        return ResponseEntity.ok(this.service.obtener());
    }
}
