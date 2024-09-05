package com.talentcare.facturacion_agosto.models.DAO;

import java.util.List;

import com.talentcare.facturacion_agosto.models.entity.Cliente;

public interface IClienteDAO {
    public List<Cliente> findAll();
    public void save (Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);

}
