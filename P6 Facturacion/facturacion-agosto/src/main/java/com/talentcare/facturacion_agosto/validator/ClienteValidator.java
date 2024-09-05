package com.talentcare.facturacion_agosto.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.talentcare.facturacion_agosto.models.entity.Cliente;

@Component
public class ClienteValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        
        return Cliente.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cliente cliente = (Cliente) target;

        if(cliente.getNombre().matches("[a-z,A-Z]{1,15}?[ ]?[a-z,A-Z]{1,15}")){

            errors.rejectValue("nombre", "El nombre no es valido");
        }

        if(cliente.getNumeroTelefono().matches("[0-9]{10}")){

            errors.rejectValue("numeroTelefono", "El numero de telefono no es de 10 digitos");
        }

        if(cliente.getDiaCreacion() == null){

            errors.rejectValue("diaCreacion", "La fecha no puede ser nula");
        } else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try{
                dateFormat.parse(dateFormat.format(cliente.getDiaCreacion()));
            } catch (ParseException e){
                errors.rejectValue("diaCreacion", "El formato de la fecha no es correcto");
            } catch (Exception e){
                errors.rejectValue("diaCreacion", "El formato de la fecha no es correcto");
            
        }
    }
    }
}
