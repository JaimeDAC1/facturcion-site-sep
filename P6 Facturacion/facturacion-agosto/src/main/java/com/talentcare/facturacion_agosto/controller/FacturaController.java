package com.talentcare.facturacion_agosto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.talentcare.facturacion_agosto.DTO.FacturaDTO;
import com.talentcare.facturacion_agosto.models.DAO.ClienteDAOImpl;
import com.talentcare.facturacion_agosto.models.DAO.FacturaDAOImpl;
import com.talentcare.facturacion_agosto.models.entity.Cliente;
import com.talentcare.facturacion_agosto.models.entity.Factura;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@SessionAttributes("factura")

public class FacturaController {
    @Autowired
    private FacturaDAOImpl facturaDAOImpl;

    @Autowired
    private ClienteDAOImpl clienteDAOImpl;

    @GetMapping("/facturas")
        
    public List<Factura> facturaList(){
        return facturaDAOImpl.findAll();
    }

    @GetMapping("/facturas/{id}")
    public Factura getFacturaByIdFactura(@PathVariable(name = "id") Long id) {
        return facturaDAOImpl.findOne(id);
    }

    @DeleteMapping ("/facturas/{id}")
    public void deleteFactura(@PathVariable(name = "id", required = true) Long id){
        try{
            facturaDAOImpl.delete(id);
        } catch (Exception e){
            e.printStackTrace();
        } 
    }

    @PostMapping ("/guardar-factura")
        public ResponseEntity<?> guardarFactura(@RequestBody FacturaDTO facturaDTO, BindingResult result) {
        Factura facturaAux = new Factura();
        Cliente clienteAux = new Cliente();
    
        if(result.hasErrors()){
            result.getAllErrors();
            return ResponseEntity.badRequest().body("Error en la validacion de datos, cantidad de errores"+result.getAllErrors());

        } else {
            facturaAux.setFecha(facturaDTO.getFecha());
            facturaAux.setMonto(facturaDTO.getMonto());
            facturaAux.setDetalle(facturaDTO.getDetalle());

            clienteAux = clienteDAOImpl.findOne(facturaDTO.getCliente());
            facturaAux.setCliente(clienteAux);


            facturaDAOImpl.save(facturaAux);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado un cliente"); //Usar build despues

        }

        }


}
