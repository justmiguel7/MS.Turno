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
    public ResponseEntity<TurnoDTO> persistirTurno(@Valid @RequestBody TurnoDTO turnoDTO) throws Exception {
        turnoService.agregarTurno(turnoDTO);
        return new ResponseEntity<>(turnoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/buscarPorDniPaciente/{dnipaciente}")
    public ResponseEntity<Turno> buscarPorDniPaciente(@PathVariable String dnipaciente) throws Exception {
        return new ResponseEntity<>(turnoService.BuscarPorDniPaciente(dnipaciente), HttpStatus.OK);
    }

    @GetMapping("/buscarPorDniOdontologo/{dniodontologo}")
    public ResponseEntity<Turno> buscarPorDniOdontologo(@PathVariable String dniodontologo) throws Exception {
        return new ResponseEntity<>(turnoService.BuscarPorDniOdontologo(dniodontologo), HttpStatus.OK);
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Turno>> listado() throws Exception {
        return new ResponseEntity<>(turnoService.listado(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idturno}")
    public ResponseEntity<Void> eliminar(@PathVariable int idturno) throws Exception {
        turnoService.eliminar(idturno);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
