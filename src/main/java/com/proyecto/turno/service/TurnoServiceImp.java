package com.proyecto.turno.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  // <-- IMPORTANTE

import com.proyecto.turno.entidades.Turno;
import com.proyecto.turno.repository.TurnoRepository;
import com.proyecto.turno.dto.TurnoDTO;

@Service   // <-- ESTA ANOTACIÓN ES LA CLAVE
public class TurnoServiceImp implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public Turno agregarTurno(TurnoDTO turnoDTO) throws Exception {
        String codigo = UUID.randomUUID().toString();
        return turnoRepository.save(turnoDTO.toEntity(codigo));
    }

    @Override
    public Turno BuscarPorPacienteID(int idpaciente) throws Exception {
        Optional<Turno> optTurno = turnoRepository.findByIdpaciente(idpaciente);
        return optTurno.orElseThrow(() -> new Exception("Turno no encontrado con pacienteid: " + idpaciente));
    }

    @Override  
    public Turno BuscarPorOdontologoID(int idodontologo) throws Exception {
        Optional<Turno > optTurno  = turnoRepository.findByIdodontologo(	idodontologo);
        return optTurno .orElseThrow(() -> new Exception("Paciente no encontrado con Odontologoid: " + idodontologo));
    }

    @Override
    public List<Turno > listado() throws Exception {
        return turnoRepository.findAll();
    }

    @Override
    public void eliminar(int idturno) throws Exception {
        Optional<Turno > optTurno  = turnoRepository.findById(idturno);
        Turno  turno  = optTurno .orElseThrow(() -> new Exception("Turno no encontrado con DNI: " + idturno));
        turnoRepository.delete(turno);
    }
}
