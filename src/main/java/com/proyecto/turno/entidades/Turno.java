package com.proyecto.turno.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;



@Entity
@Data
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idturno;
	
	@Column(name = "Idpaciente")
	private int idpaciente;
	
	@Column(name = "Idodontologo")
	private int idodontologo;
	

	@Column(name = "FechaYHora")
	private LocalDateTime FechaYHora;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoTurno estado;

public Turno() {
	
}
	public Turno(int idpaciente, int idodontologo, LocalDateTime FechaYHora, EstadoTurno estado) {
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


	public void setFechaYHora(LocalDateTime fechaYHora) {
		FechaYHora = fechaYHora;
	}


	public Enum getEstado() {
		return estado;
	}


	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}


	
	
	
}
