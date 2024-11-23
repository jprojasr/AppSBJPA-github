package com.jrojas.appsbjpa.controladores;

import com.jrojas.appsbjpa.modelo.dao.DireccionDAO;
import com.jrojas.appsbjpa.modelo.dto.AreaDTO;
import com.jrojas.appsbjpa.modelo.dto.ClienteDTO;
import com.jrojas.appsbjpa.modelo.dto.DireccionDTO;
import com.jrojas.appsbjpa.modelo.servicios.IProyectoServicio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ProyectoControlador {

    @Autowired
    @Qualifier("ClienteSERVICIO_JPA")
    private IProyectoServicio clienteServicio;


    @GetMapping("")
    public String index(Model model){
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes",clienteServicio.listarClientesTodos());
        return "listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes",clienteServicio.listarClientesTodos());
        return "listar";
    }

    @GetMapping("/listarPorCiudad")
    public String listarPorCiudad(Model model){
        model.addAttribute("titulo","Listado de Clientes por Ciudad");
        model.addAttribute("ciudades", clienteServicio.listarCiudadesTodasUnicas());
        return "listarCiudades";
    }

    @PostMapping("/listarPorCiudad")
    public String listarClientesPorCiudad(@RequestParam String ciudad , Model model){
        if(ciudad.isEmpty()){
            model.addAttribute("titulo","Listado de Clientes por Ciudad");
            model.addAttribute("ciudades", clienteServicio.listarCiudadesTodasUnicas());
            return "redirect:/listarCiudades";
        }else{
            model.addAttribute("titulo","Listado de Clientes por Ciudad");
            model.addAttribute("titulo2","Clientes de "+ciudad);
            model.addAttribute("ciudades", clienteServicio.listarCiudadesTodasUnicas());
            model.addAttribute("clientes",clienteServicio.listarClientesPorCiudad(ciudad));
            return "/listarCiudades";
        }

    }



    @GetMapping("/formulario/{id}")
    public String editar(@PathVariable Integer id, Model model){
        ClienteDTO cliente = null;
        if(id > 0){
            cliente = clienteServicio.buscarClientesPorId(id);
        }else{
            return "redirect:/listar";
        }
        model.addAttribute("titulo","Editar Cliente");
        model.addAttribute("cliente",cliente);
        model.addAttribute("urlDestino", "/actualizar");
        return "formulario";
    }

    @PostMapping("/actualizar")
    public String actualizar(@Valid @ModelAttribute("cliente") ClienteDTO cliente, BindingResult resultado, Model model){
        if(resultado.hasErrors()){
            model.addAttribute("titulo","Editar Cliente - VALIDACION");
            model.addAttribute("urlDestino", "/actualizar");
            return "formulario";
        }
        clienteServicio.editarClientes(cliente);
        return "redirect:/listar";
    }

    @GetMapping("/formulario")
    public String agregarGet(Model model){
        model.addAttribute("titulo","Formulario de Cliente");
        ClienteDTO c = new ClienteDTO();
        c.setDireccion(new DireccionDTO());
        c.setAreas(new ArrayList<AreaDTO>());
        model.addAttribute("cliente",c);
        model.addAttribute("urlDestino", "/formulario");
        return "formulario";
    }

    @PostMapping("/formulario")
    public String agregarPost(@Valid @ModelAttribute("cliente") ClienteDTO cliente, BindingResult resultado, Model model){
        if(resultado.hasErrors()){
            model.addAttribute("titulo","Formulario de Cliente - VALIDACION");
            model.addAttribute("urlDestino", "/formulario");
            return "formulario";
        }
        clienteServicio.guardarClientes(cliente);
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        if(id > 0){
            clienteServicio.eliminarClientes(id);
        }
        return "redirect:/listar";
    }




}
