package com.jrojas.appsbjpa.modelo.dao;

import com.jrojas.appsbjpa.modelo.dto.ClienteDTO;

import java.util.List;

public interface IClienteDAO {
    //Método creado para mostrar todos los registros existentes en la BD
    public List<ClienteDTO> listarClientesTodos();

    public List<ClienteDTO> listarClientesPorCiudad(String ciudad);

    //Método creado para guardar nuevos registros de clientes en la BD y editar registros existentes en la BD
    public void guardarClientes(ClienteDTO cliente);

    //Método creado para buscar objetos de Cliente por su ID
    public ClienteDTO buscarClientesPorId(Integer id);

    //Método creado para eliminar registros de la BD por su ID
    public void eliminarClientes(Integer id);

    //TAREA: Separar el método guardar() para que solo guarde, y crear otro método acá para editar
    public void editarClientes(ClienteDTO cliente);
}
