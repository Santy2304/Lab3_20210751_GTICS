package com.example.lab03_clinica.Repository;

import com.example.lab03_clinica.Entity.Oftalmologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OftaRepository extends JpaRepository<Oftalmologo,Integer> {

    List<Oftalmologo> findByClinica_id(int clinica_id);


}
