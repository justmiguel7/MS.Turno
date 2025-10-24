package com.proyecto.turno.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.turno.entidades.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    Optional<Turno> findByDnipaciente(String dnipaciente) throws Exception;
    Optional<Turno> findByDniodontologo(String dniodontologo) throws Exception;
}
