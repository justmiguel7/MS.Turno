package com.proyecto.turno.service;

import java.time.LocalDateTime;
import java.util.List;
import com.proyecto.turno.dto.TurnoDTO;
import com.proyecto.turno.entidades.Turno;

public interface TurnoService {
    Turno agregarTurno(TurnoDTO turnoDTO) throws Exception;
    List<Turno> BuscarPorDniPaciente(String dnipaciente) throws Exception;
    List<Turno> BuscarPorDniOdontologo(String dniodontologo) throws Exception;
    List<Turno> listado() throws Exception;
    void eliminar(int idturno) throws Exception;
    boolean existsByFechaYHora(LocalDateTime fechaYHora);
    Turno confirmarTurno(int idturno, String dniOdontologo) throws Exception;
    Turno crearTurnoPaciente(TurnoDTO turnoDTO) throws Exception;
    Turno cancelarTurno(int idturno) throws Exception; 
}
