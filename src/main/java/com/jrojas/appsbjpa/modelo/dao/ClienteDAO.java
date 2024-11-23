package com.jrojas.appsbjpa.modelo.dao;

import com.jrojas.appsbjpa.modelo.dto.ClienteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ClienteDAO_JPA")
public class ClienteDAO implements IClienteDAO{

    @PersistenceContext
    private EntityManager em;



    @Override
    public List<ClienteDTO> listarClientesTodos() {
        return em.createQuery("select c from ClienteDTO c", ClienteDTO.class).getResultList();
    }

    @Override
    public List<ClienteDTO> listarClientesPorCiudad(String ciudad) {
        return em.createQuery("select c from ClienteDTO c where c.direccion.ciudad = :ciudad", ClienteDTO.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }


    @Override
    public ClienteDTO buscarClientesPorId(Integer id) {
        return em.find(ClienteDTO.class, id);
    }


    @Override
    public void guardarClientes(ClienteDTO cliente) {
        em.persist(cliente);
    }


    @Override
    public void eliminarClientes(Integer id) {
        ClienteDTO cliente = buscarClientesPorId(id);
        em.remove(cliente);
    }

    @Override
    public void editarClientes(ClienteDTO cliente) {
        em.merge(cliente);
    }


}
