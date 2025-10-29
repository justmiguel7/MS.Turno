package com.proyecto.turno.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.turno.entidades.Turno;
import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    List<Turno> findByDnipaciente(String dnipaciente);
    List<Turno> findByDniodontologo(String dniodontologo);
}
