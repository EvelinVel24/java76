package main.java.com.farmacia.controller;

import com.farmacia.model.Farmacia;
import com.farmacia.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    // Mostrar lista de medicamentos
    @GetMapping("/medicamentos")
    public String listarMedicamentos(Model model) {
        List<Farmacia> medicamentos = farmaciaService.listarMedicamentos();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos"; // Plantilla Thymeleaf para mostrar medicamentos
    }

    // Agregar nuevo medicamento
    @PostMapping("/medicamentos/agregar")
    public String agregarMedicamento(@RequestParam String nombreMedicamento, 
                                      @RequestParam double precio) {
        farmaciaService.agregarMedicamento(nombreMedicamento, precio);
        return "redirect:/medicamentos"; // Redirige a la lista actualizada
    }
}
