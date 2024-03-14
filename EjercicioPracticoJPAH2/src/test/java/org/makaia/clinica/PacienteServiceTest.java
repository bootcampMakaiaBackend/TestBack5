package org.makaia.clinica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makaia.clinica.exceptions.ApiException;
import org.makaia.clinica.models.Paciente;
import org.makaia.clinica.repositories.PacienteRepository;
import org.makaia.clinica.services.PacienteService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PacienteServiceTest {

    //1 Mirar las dependencias que tiene Paciente service
    private PacienteService pacienteService;
    private PacienteRepository pacienteRepository;
    //2 Cuales serian los mocks? -> pacienteRepository seria mi mock.!
    //3 haga el BeforeEach
    @BeforeEach
    public void construir(){
        // Como se crea un mock??
        pacienteRepository = mock(PacienteRepository.class);
        this.pacienteService = new PacienteService(pacienteRepository);
    }

    @Test
    public void crearPacienteCuandoDniEsNulo(){
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Corrales");
        //Act   //Assert
        assertThrows(ApiException.class, () -> this.pacienteService.crear(paciente) );
    }

    @Test
    public void crearPacienteCuandoApellidoEsNulo(){
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setDni(1231231231);
        paciente.setNombre("Juan");
        //Act   //Assert
        assertThrows(ApiException.class, () -> this.pacienteService.crear(paciente) );
    }

    @Test
    public void crearPacienteCuandoElPacienteExiste(){
        //Arrange
        Paciente paciente = new Paciente(123, "Ana", "Gomez", "Bogota");
        //Voy a simular una respuesta
        when(pacienteRepository.existsById(any())).thenReturn(true);
        ApiException exp = assertThrows(ApiException.class, () -> this.pacienteService.crear(paciente) );
        assertTrue(exp.getMessage().contains("ya existe en la base de datos."));
    }

    @Test
    public void crearPacienteCuandoNoExistaEnLaBaseDeDatos(){
        //Arrange
        Paciente paciente = new Paciente(123, "Ana", "Gomez", "Bogota");
        when(pacienteRepository.existsById(any())).thenReturn(false);
        when(pacienteRepository.save(any())).thenReturn(paciente);
        //act
        Paciente pacienteCreado =  this.pacienteService.crear(paciente);
        //Assert
        assertEquals(123, pacienteCreado.getDni());
    }

    @Test
    public void crearPacienteCuandoNoExistaEnLaBaseDeDatosVerificandoSave(){
        Paciente paciente = new Paciente(123, "Ana", "Gomez", "Bogota");
        when(pacienteRepository.existsById(any())).thenReturn(false);
        //act
        Paciente pacienteCreado =  this.pacienteService.crear(paciente);
        //asert
        verify(pacienteRepository, times(1)).save(any());

    }

    @Test
    public void crearPacienteNulo(){
        //Arrange
        Paciente paciente = null;
        //Act
        assertThrows(ApiException.class, () -> this.pacienteService.crear(paciente));
    }

}
