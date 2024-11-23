package com.jrojas.appsbjpa.modelo.servicios;

import com.jrojas.appsbjpa.modelo.dto.ClienteDTO;

import java.util.List;

public interface IProyectoServicio {

    //Metodo creado para mostrar todos los registros existentes en la BD.
    public List<ClienteDTO> listarClientesTodos();

    public List<ClienteDTO> listarClientesPorCiudad(String ciudad);
    // Metodo para guardar nuevos registros de cliente en la BD y editar registros existentes en la BD.
    public void guardarClientes(ClienteDTO cliente);
    //Metodo para buscar objetos de Cliente por su ID.
    public ClienteDTO buscarClientesPorId(Integer id);

    //Metodo creado para eliminar registros en la BD por su ID.
    public void eliminarClientes(Integer id);

    public void editarClientes(ClienteDTO cliente);

    public List<String> listarCiudadesTodasUnicas();
}


