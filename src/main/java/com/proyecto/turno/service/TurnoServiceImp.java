package com.proyecto.turno.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.turno.entidades.EstadoTurno;
import com.proyecto.turno.entidades.Turno;
import com.proyecto.turno.repository.TurnoRepository;
import com.proyecto.turno.dto.TurnoDTO;

@Service
public class TurnoServiceImp implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

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
    
}
