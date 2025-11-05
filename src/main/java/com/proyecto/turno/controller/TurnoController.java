package com.proyecto.turno.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.proyecto.turno.dto.TurnoDTO;
import com.proyecto.turno.entidades.Turno;
import com.proyecto.turno.service.TurnoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping("/agregar")
    public ResponseEntity<?> persistirTurno(@Valid @RequestBody TurnoDTO turnoDTO) {
        try {
            turnoService.crearTurnoPaciente(turnoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(turnoDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear turno: " + e.getMessage());
        }
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Turno>> listado() throws Exception {
        return new ResponseEntity<>(turnoService.listado(), HttpStatus.OK);
    }

    @PutMapping("/confirmar/{idturno}")
    public ResponseEntity<?> confirmarTurno(@PathVariable int idturno,
                                            @RequestBody String dniOdontologo) {
        try {
            Turno turnoConfirmado = turnoService.confirmarTurno(idturno, dniOdontologo);
            return ResponseEntity.ok(turnoConfirmado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/odontologo/{dni}")
    public ResponseEntity<List<Turno>> listarPorDniOdontologo(@PathVariable String dni) throws Exception {
        List<Turno> turnos = turnoService.BuscarPorDniOdontologo(dni);
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }
}
