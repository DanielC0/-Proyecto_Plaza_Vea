package com.plazavea.proyecto.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plazavea.proyecto.Model.Empleado;
import com.plazavea.proyecto.Service.EmpleadoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/empleado")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;


    @GetMapping("/listarEmpleados")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaEmpleados", empleadoService.listarEmpleado());
        return "empleados/empleados";
    }

    @GetMapping("/nuevoEmpleado")
    public String nuevoEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "empleados/nuevoEmpleado";
    }


    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleado/listarEmpleados";
    }


    @GetMapping("/actualizarEmpleado/{id}")
    public String actualizarEmpleado(@PathVariable("id") Long id, Model model){
        model.addAttribute("empleado", empleadoService.obtenerEmpleadoPorId(id));
        return "empleados/actualizarEmpleado";

    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable("id")Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleado/listarEmpleados";
    }

    



    
}
