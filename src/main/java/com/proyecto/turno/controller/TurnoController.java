package com.proyecto.turno.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.turno.entidades.Turno;
import com.proyecto.turno.dto.TurnoDTO;

import com.proyecto.turno.service.TurnoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "false")
@RequestMapping("/turno")
public class TurnoController {

	
	
	@Autowired
	private TurnoService turnoService;
		

  @RequestMapping(value="/agregar", method={RequestMethod.POST})
	public ResponseEntity<TurnoDTO> persistirTurno (@Valid @RequestBody  TurnoDTO turnoDTO ) throws Exception{
		
	  turnoService.agregarTurno(turnoDTO);

		return new ResponseEntity<TurnoDTO>(turnoDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/buscar/{pacienteid}", method={RequestMethod.GET})
	public ResponseEntity<Turno> BuscarPorPacienteID ( @PathVariable("idpaciente") int idpaciente) throws Exception{
		Turno turno = turnoService.BuscarPorPacienteID(idpaciente);
		  return new ResponseEntity<>(turno,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/BuscarPorOdontologoID/{odontologoid}", method={RequestMethod.GET})
	public ResponseEntity<Turno> BuscarPorOdontologoID ( @PathVariable("idodontologo") int idodontologo) throws Exception{
		Turno turno = turnoService.BuscarPorOdontologoID(idodontologo);
		  return new ResponseEntity<>(turno,HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/listado", method={RequestMethod.GET})
	public ResponseEntity<List<Turno>> listado() throws Exception{
		  return new ResponseEntity<>(turnoService.listado(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/eliminar/{id}", method={RequestMethod.GET})
	public ResponseEntity<Turno> eliminar(@PathVariable("idturno") int idturno) throws Exception{
		turnoService.eliminar(idturno);
		  return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}

