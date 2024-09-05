package com.talentcare.facturacion_agosto.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.talentcare.facturacion_agosto.models.entity.Cliente;
import com.talentcare.facturacion_agosto.models.entity.Factura;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FacturaDAOImpl implements IFacturaDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void delete(Long id) {
        try{
            em.remove(this.findOne(id));
        } catch (Exception e){
            e.printStackTrace();        
        }
        
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Factura> findAll() {
        return em.createQuery("from factura").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findOne(Long id) {
        
        return em.find(Factura.class, id);
    }

   

    @Override
    public void save(Factura factura) {
       if(factura.getId() != null && factura.getId() > 0){
        try{
            em.merge(factura);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        
       }
       else{
        try{
            em.persist(factura);
        } catch (EntityExistsException e){
            e.printStackTrace();
        }
       }
    }
    

}
