package com.proyecto.turno.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.turno.dto.TurnoDTO;
import com.proyecto.turno.entidades.EstadoTurno;
import com.proyecto.turno.entidades.Turno;
import com.proyecto.turno.repository.TurnoRepository;

@Service
public class TurnoServiceImp implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public Turno crearTurnoPaciente(TurnoDTO turnoDTO) throws Exception {
        // Normalizar la fecha
        LocalDateTime fecha = turnoDTO.getFechaYHora().withNano(0);

        // Verificar duplicado
        if (turnoRepository.existsByFechaYHora(fecha)) {
            throw new IllegalArgumentException("Ya existe un turno reservado para esa fecha y hora.");
        }

        // Crear turno
        Turno turno = new Turno();
        turno.setDnipaciente(turnoDTO.getDnipaciente());
        turno.setDniodontologo(turnoDTO.getDniodontologo());
        turno.setFechaYHora(fecha);
        turno.setEstado(turnoDTO.getEstado() != null ? turnoDTO.getEstado() : EstadoTurno.PENDIENTE);

        return turnoRepository.save(turno);
    }

    @Override
    public Turno agregarTurno(TurnoDTO turnoDTO) throws Exception {
        String codigo = UUID.randomUUID().toString();
        return turnoRepository.save(turnoDTO.toEntity(codigo));
    }

    @Override
    public List<Turno> BuscarPorDniPaciente(String dnipaciente) throws Exception {
        return turnoRepository.findByDnipaciente(dnipaciente);
    }

    @Override
    public List<Turno> BuscarPorDniOdontologo(String dniodontologo) throws Exception {
        return turnoRepository.findByDniodontologo(dniodontologo);
    }

    @Override
    public List<Turno> listado() throws Exception {
        return turnoRepository.findAll();
    }

    @Override
    public void eliminar(int idturno) throws Exception {
        Turno turno = turnoRepository.findById(idturno)
                .orElseThrow(() -> new Exception("Turno no encontrado con ID: " + idturno));
        turnoRepository.delete(turno);
    }

    @Override
    public Turno confirmarTurno(int idturno, String dniOdontologo) throws Exception {
        Turno turno = turnoRepository.findById(idturno)
                .orElseThrow(() -> new Exception("Turno no encontrado con ID: " + idturno));

        if (turno.getEstado() != EstadoTurno.PENDIENTE) {
            throw new Exception("El turno ya está confirmado o cancelado.");
        }

        turno.setEstado(EstadoTurno.CONFIRMADO);
        turno.setDniodontologo(dniOdontologo);
        return turnoRepository.save(turno);
    }

    @Override
    public boolean existsByFechaYHora(LocalDateTime fechaYHora) {
        return turnoRepository.existsByFechaYHora(fechaYHora);
    }
    
    @Override
    public Turno cancelarTurno(int idturno) throws Exception {
        Turno turno = turnoRepository.findById(idturno)
                .orElseThrow(() -> new Exception("Turno no encontrado con ID: " + idturno));

        if (turno.getEstado() == EstadoTurno.CANCELADO) {
            throw new Exception("El turno ya se encuentra cancelado.");
        }



        turno.setEstado(EstadoTurno.CANCELADO);
        return turnoRepository.save(turno);
    }
    
}
