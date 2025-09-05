package br.com.fiap.projetos.controller;

import br.com.fiap.projetos.dto.RecursoDTO;
import br.com.fiap.projetos.service.RecursoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/recursos")
@AllArgsConstructor
@Log
public class RecursoController {

    private final RecursoService recursoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("recursos", recursoService.findAll());
        return "recursos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("recurso", new RecursoDTO());
        return "recursos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") RecursoDTO recurso, BindingResult bindingResults, Model model){
        if (bindingResults.hasErrors()) {
            bindingResults.getAllErrors().forEach(e-> log.info(e.toString()));
            model.addAttribute("recurso", recurso);
            return "recursos/formulario";
        }
        recursoService.save(recurso);
        return "redirect:/recursos";
    }

    @GetMapping("/editar/{uuid}")
    public String editar(@PathVariable UUID uuid, Model model) {
        model.addAttribute("recurso", recursoService.findById(uuid));
        return "recursos/formulario";
    }

    @GetMapping("/deletar/{uuid}")
    public String deletar(@PathVariable UUID uuid){
        recursoService.apagar(uuid);
        return "redirect:/recursos";
    }


}
