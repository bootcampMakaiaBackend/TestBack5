# EjercicioPractico JPA y H2

## Desarrollo ejercicio práctico JPA y H2 dentro del desarrollo del BootCamp de desarrollo web BackEnd de MAKAIA.

### El repositorio corresponde a parte de la respuesta al taller planteado:

### EJERCICIO PRACTICO JPA + SPRING BOOT + SPRING DATA.

#### Clínica MAKAIA, requiere realizar un api en la cual se puedan, agregar, eliminar y obtener todos los pacientes del consultorio, además de esto también se deben poder gestionar la creación, eliminación de los odontólogos y su vez obtener todos los odontólogos del consultorio.

#### Un odontólogo está definido por:
* Nombre
* Apellido
* Matricula

#### Un Paciente esta definido por:
* Nombre
* Apellido
* Domicilio
* Dni

#### Esta clínica debe exponer un api que será consumida por un frontEnd para la asignación de turnos virtuales, una cita esta asignada para un odontólogo y un paciente en determinada fecha.

#### Cuando se agine una cita o turno se debe tener en cuenta las siguientes validaciones:
* Que Exista el odontólogo.
* Que exista el paciente
* Que la matricula, el DNI y la fecha de turno sea diferente de null y mayor a 0.
* Si todo esto cumple se debe guardar el turno.

#### Un turno esta definido por:
* Odontólogo
* Paciente
* Fecha del turno.

#### Ejemplo de la petición: localhost:8080/api/v1/odontologo/1/paciente/1234/fecha/2023-12-12/asignar

#### Ejemplo de la respuesta:
{
  "odontologo": {
    "apellido": "perez",
    "nombre": "Mateo",
    "matricula": 1
  },
  "paciente": {
    "nombre": "Juan",
    "apellido": "lopez",
    "domicilio": "Medellin",
    "dni": 1234,
  },
  "fechaTurno": "2023-03-22T22:02:23.775212"
}

#### NOTA: toda esta información se debe persistir en la base de datos.



### Para verificar la solución al ejercicio planteado es necesario descargar el proyecto, ejecutarlo y utilizar el archivo Clínica MAKAIA.postman_collection.json importarlo en postman y con el realizar las pruebas para verificar el funcionamiento del microservicio.
