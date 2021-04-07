package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente cliente){
        clientes.add(cliente);

        return cliente;
    }
}
