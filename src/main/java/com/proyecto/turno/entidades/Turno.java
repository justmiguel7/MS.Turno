package com.proyecto.turno.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Turno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idturno;

    @Column(name = "dnipaciente")
    private String dnipaciente;

    @Column(name = "dniodontologo")
    private String dniodontologo;

    @Column(name = "FechaYHora")
    private LocalDateTime fechaYHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoTurno estado;

    public Turno() {}

    public Turno(String dnipaciente, String dniodontologo, LocalDateTime fechaYHora, EstadoTurno estado) {
        this.dnipaciente = dnipaciente;
        this.dniodontologo = dniodontologo;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
    }
}
