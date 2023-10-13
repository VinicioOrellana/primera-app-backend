package com.company.intecap.apirestlibros.controller;

import com.company.intecap.apirestlibros.models.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")   // es el prefijo de la Url

public class ClienteController {

    @GetMapping("/index")   //    http://localhost:8080/api/v1/index

    public String getIndex()
    {
        return "Bienvenido a mi API REST Spring Boot";
    }

    @GetMapping("/clientes")  //  http://localhost:8080/api/v1/clientes
    public List<Cliente> getClientes(){
        //Crear 3 clientes

        Cliente c1 = new Cliente(1,"Vinicio","Orellana","Dir1","Tel1","Email1");
        Cliente c2 = new Cliente(2,"Damaris","Umaña","Dir2","Tel2","Email2");
        Cliente c3 = new Cliente(3,"Arely","Orellana","Dir3","Tel3","Email3");

        List<Cliente> clientes = List.of(c1,c2,c3);
        return clientes;

    }

    @GetMapping("/clientes2")  // http://localhost:8080/api/v1/clientes2  ejemplo con httpresponse
    public ResponseEntity<List<Cliente>> getClientes2(){
        Cliente c1 = new Cliente(1,"Vinicio","Orellana","Dir1","Tel1","Email1");
        Cliente c2 = new Cliente(2,"Damaris","Umaña","Dir2","Tel2","Email2");
        Cliente c3 = new Cliente(3,"Arely","Orellana","Dir3","Tel3","Email3");
        List<Cliente> clientes = List.of(c1,c2,c3);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/success")
    public ResponseEntity<String> getSuccess(){
        return new ResponseEntity<>("Respuesta satisfactoria", HttpStatus.ACCEPTED);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> getNotFound(){
        return new ResponseEntity<>("no se encontro el recurso", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
