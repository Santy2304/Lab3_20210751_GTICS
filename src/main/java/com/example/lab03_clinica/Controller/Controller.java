package com.example.lab03_clinica.Controller;

import com.example.lab03_clinica.Entity.Oftalmologo;
import com.example.lab03_clinica.Entity.Paciente;
import com.example.lab03_clinica.Repository.ClinicaRepository;
import com.example.lab03_clinica.Repository.OftaRepository;
import com.example.lab03_clinica.Repository.PacienteRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    final ClinicaRepository clinicaRepository;

    final OftaRepository oftaRepository;

    final PacienteRepository pacienteRepository;

    public Controller(ClinicaRepository clinicaRepository, OftaRepository oftaRepository, PacienteRepository pacienteRepository) {
        this.clinicaRepository = clinicaRepository;
        this.oftaRepository = oftaRepository;
        this.pacienteRepository = pacienteRepository;

    }

    @GetMapping("/listaClinicas")
    public String listar(Model model) {

        model.addAttribute("listaClinicas", clinicaRepository.findAll());
        return "Clinica/listaClinicas";
    }

    @GetMapping("/listarOftaClinica")
    public String listarOftaClinica(@RequestParam("clinica_id") int clinica_id, Model model) {
        List<Oftalmologo> listaOftaClinica = oftaRepository.findByClinica_id(clinica_id);
        model.addAttribute("listaOftaClinica", listaOftaClinica);

        return "Clinica/listaOftaClinicas";
    }

    @GetMapping("/listarPacienteClinica")
    public String listarPacienteClinica(@RequestParam("clinica_id") int clinica_id, Model model) {
        List<Paciente> listaPacienteClinica = pacienteRepository.findByClinica_id(clinica_id);
        model.addAttribute("listaPacienteClinca", listaPacienteClinica);

        return "Clinica/listaPacienteClinica";
    }

    @GetMapping("/listarPacientes")
    public String listarPacientes(Model model) {

        model.addAttribute("listaPacientes", pacienteRepository.findAll());
        return "Paciente/listaPacientes";
    }


    @GetMapping("/EditarPaciente")
    public String editarMascota(@RequestParam("id_paciente") int id_paciente, Model model) {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id_paciente);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            model.addAttribute("paciente", paciente);
            return "Paciente/editarPaciente";
        } else {
            return "redirect:/listarPacientes";
        }
    }

    @PostMapping("/guardarHabitacion")
    public String guardarHabitacion(Paciente paciente) {
        pacienteRepository.actualizarHabitacion(paciente.getNumero_habitacion(), paciente.getId());
        return "redirect:/listarPacientes";
    }



    @GetMapping("/listarOftalmologos")
    public String listarOftalmologos(Model model) {

        model.addAttribute("listaOftalmologos", oftaRepository.findAll());
        return "Oftalmologo/listaOftalmologos";
    }

}
