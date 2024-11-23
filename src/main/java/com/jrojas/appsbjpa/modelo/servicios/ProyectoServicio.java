package com.jrojas.appsbjpa.modelo.servicios;

import com.jrojas.appsbjpa.modelo.dao.IClienteDAO;
import com.jrojas.appsbjpa.modelo.dao.IDireccionDAO;
import com.jrojas.appsbjpa.modelo.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ClienteSERVICIO_JPA")
public class ProyectoServicio implements IProyectoServicio {

    @Autowired
    private IClienteDAO clienteDAO;

    @Autowired
    private IDireccionDAO direccionDAO;


    @Transactional(readOnly = true)
    @Override
    public List<ClienteDTO> listarClientesTodos() {
        return clienteDAO.listarClientesTodos();
    }

    @Override
    public List<ClienteDTO> listarClientesPorCiudad(String ciudad) {
        return clienteDAO.listarClientesPorCiudad(ciudad);
    }

    @Transactional
    @Override
    public void guardarClientes(ClienteDTO cliente) {
        clienteDAO.guardarClientes(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteDTO buscarClientesPorId(Integer id) {
        return clienteDAO.buscarClientesPorId(id);
    }

    @Transactional
    @Override
    public void eliminarClientes(Integer id) {
        clienteDAO.eliminarClientes(id);
    }

    @Transactional
    @Override
    public void editarClientes(ClienteDTO cliente) {
        clienteDAO.editarClientes(cliente);
    }

    @Override
    public List<String> listarCiudadesTodasUnicas() {
        return direccionDAO.listarCiudadesTodasUnicas();
    }
}
