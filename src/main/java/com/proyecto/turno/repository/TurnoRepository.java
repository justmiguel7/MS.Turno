package com.proyecto.turno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.turno.entidades.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Integer>{

	public Optional<Turno> findByIdpaciente(int idpaciente) throws Exception; 
	
	public Optional<Turno> findByIdodontologo(int idodontologo) throws Exception; 

	
}
