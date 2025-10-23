package com.proyecto.turno.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.proyecto.turno.entidades.EstadoTurno;
import com.proyecto.turno.entidades.Turno;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
public class TurnoDTO {

	private int idturno;
	
	

private int idpaciente;


private int idodontologo;

private LocalDateTime FechaYHora;



private EstadoTurno estado;

public Turno toEntity (String codigo) {
	return new Turno(this.idpaciente, this.idodontologo, this.FechaYHora, this.estado);
}

public TurnoDTO(int idpaciente, int idodontologo, LocalDateTime FechaYHora, LocalTime hora, EstadoTurno estado) {
	super();
	this.idpaciente = idpaciente;
	this.idodontologo = idodontologo;
	this.FechaYHora = FechaYHora;
	this.estado = estado;
	
	
}

public int getIdturno() {
	return idturno;
}

public void setIdturno(int idturno) {
	this.idturno = idturno;
}

public int getIdpaciente() {
	return idpaciente;
}

public void setIdpaciente(int idpaciente) {
	this.idpaciente = idpaciente;
}

public int getIdodontologo() {
	return idodontologo;
}

public void setIdodontologo(int idodontologo) {
	this.idodontologo = idodontologo;
}

public LocalDateTime getFechaYHora() {
	return FechaYHora;
}

public void setFechaYHora(LocalDateTime FechaYHora) {
	this.FechaYHora = FechaYHora;
}


public Enum getEstado() {
	return estado;
}

public void setEstado(EstadoTurno estado) {
	this.estado = estado;
}



}
