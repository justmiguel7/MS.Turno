package com.proyecto.turno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.turno.entidades.Turno;

import java.time.LocalDateTime;
import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    List<Turno> findByDnipaciente(String dnipaciente);
    List<Turno> findByDniodontologo(String dniodontologo);

    // 👇 Para validar duplicados
    boolean existsByFechaYHora(LocalDateTime fechaYHora);
}
