package com.proyecto.turno.dto;

import java.time.LocalDateTime;
import com.proyecto.turno.entidades.EstadoTurno;
import com.proyecto.turno.entidades.Turno;
import lombok.Data;

@Data
public class TurnoDTO {

    private int idturno;
    private String dnipaciente;
    private String dniodontologo;
    private LocalDateTime fechaYHora;
    private EstadoTurno estado;

    public Turno toEntity(String codigo) {
        return new Turno(this.dnipaciente, this.dniodontologo, this.fechaYHora, this.estado);
    }

    public TurnoDTO() {}

    public TurnoDTO(String dnipaciente, String dniodontologo, LocalDateTime fechaYHora, EstadoTurno estado) {
        this.dnipaciente = dnipaciente;
        this.dniodontologo = dniodontologo;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
    }
}
