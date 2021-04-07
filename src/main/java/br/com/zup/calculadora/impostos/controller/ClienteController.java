package br.com.zup.calculadora.impostos.controller;

import br.com.zup.calculadora.impostos.entity.Cliente;
import br.com.zup.calculadora.impostos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }
}
