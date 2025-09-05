package br.com.fiap.projetos.controller;

import br.com.fiap.projetos.dto.ProjetoDTO;
import br.com.fiap.projetos.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projetos")
@AllArgsConstructor
@Log
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("projetos", projetoService.listar());
        return "projetos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("projeto", new ProjetoDTO());
        return "projetos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("projeto") ProjetoDTO projeto, BindingResult bindingResults, Model model){
        if (bindingResults.hasErrors()) {
            bindingResults.getAllErrors().forEach(e-> log.info(e.toString()));
            model.addAttribute("projeto", projeto);
            return "projetos/formulario";
        }
        projetoService.criar(projeto);
        return "redirect:/projetos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("projeto", projetoService.findById(id));
        return "projetos/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        projetoService.apagar(id);
        return "redirect:/projetos";
    }
}