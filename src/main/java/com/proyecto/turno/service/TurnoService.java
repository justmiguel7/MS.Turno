package com.proyecto.turno.service;

import java.util.List;

import com.proyecto.turno.entidades.Turno;

import com.proyecto.turno.dto.TurnoDTO;

public interface TurnoService {

	public Turno agregarTurno(TurnoDTO turnoDTO) throws Exception;
	
	public Turno BuscarPorPacienteID (int idpaciente) throws Exception;
	
	public Turno BuscarPorOdontologoID (int idodontologo) throws Exception;
	
	public List<Turno> listado () throws Exception;
	
	public void eliminar (int idturno) throws Exception;
	
	/* Despues agregar buscar entre fechas */

	
}
