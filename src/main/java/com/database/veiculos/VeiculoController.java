package com.database.veiculos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculos")
    public String listar(@RequestParam(required = false) String busca, Model model) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("veiculos", service.buscarPorModelo(busca));
        } else {
            model.addAttribute("veiculos", service.listar());
        }
        return "veiculos";
    }

    @GetMapping("/veiculos/novo")
    public String novo(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "form";
    }

    @PostMapping("/veiculos/salvar")
    public String salvar(@ModelAttribute Veiculo veiculo) {
        service.salvar(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculos/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("veiculo", service.buscarPorId(id));
        return "form";
    }

    @PostMapping("/veiculos/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/veiculos";
    }
}