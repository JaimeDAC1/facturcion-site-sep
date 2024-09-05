package com.talentcare.facturacion_agosto.models.DAO;

import java.util.List;

import com.talentcare.facturacion_agosto.models.entity.Cliente;
import com.talentcare.facturacion_agosto.models.entity.Factura;

public interface IFacturaDAO {
    public List<Factura> findAll();
    public void save (Factura factura);
    public Factura findOne(Long id);
    public void delete(Long id);
}
