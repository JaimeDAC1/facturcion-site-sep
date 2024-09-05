package com.talentcare.facturacion_agosto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.talentcare.facturacion_agosto.models.DAO.IClienteDAO;
import com.talentcare.facturacion_agosto.models.entity.Cliente;
import com.talentcare.facturacion_agosto.validator.ClienteValidator;

@RestController
@SessionAttributes("Cliente")
public class ClienteController {

@Autowired
private IClienteDAO clienteDAO;

@Autowired
private ClienteValidator clienteValidator;

    @RequestMapping(path = "/clientes", method = RequestMethod.GET)
    public List<Cliente> clienteList(){
        return clienteDAO.findAll();
    }

    @PostMapping("/guardar-cliente")
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente, BindingResult result){
        clienteValidator.validate(cliente, result);

        if(result.hasErrors()){
            result.getAllErrors();
            return ResponseEntity.badRequest().body("Error en la validacion de datos, cantidad de errores"+result.getAllErrors());

        } else {
            clienteDAO.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado un cliente"); //Usar build despues

        }
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteByID(@PathVariable(name="id", required = true) Long id){
        return clienteDAO.findOne(id);
    }

    @DeleteMapping("/delete-cliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable(name="id", required = true) Long id){
        try{
    clienteDAO.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Se ha elimindado correctamente.");
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("El id no existe.");
        }/*catch(UnexpectedRollbackException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("El id no existe.");
        }*/catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No fue posible eliminar al usuario, contacte al administrador.");

        }
    }


}