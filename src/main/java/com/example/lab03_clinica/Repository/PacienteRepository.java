package com.example.lab03_clinica.Repository;

import com.example.lab03_clinica.Entity.Oftalmologo;
import com.example.lab03_clinica.Entity.Paciente;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByClinica_id(int clinica_id);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update paciente set numero_habitacion=?1  where id = ?2")
    void actualizarHabitacion(String numero_habitacion, int id_paciente);

}
