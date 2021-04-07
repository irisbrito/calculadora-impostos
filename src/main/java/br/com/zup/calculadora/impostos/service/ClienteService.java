package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.Cliente;
import br.com.zup.calculadora.impostos.entity.Produto;
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

    public Cliente cadastrarCliente (String nome){
        for(Cliente cliente : clientes){
            if(cliente.getNome().equalsIgnoreCase(nome)){
                return cliente;
            }
        }
        throw new RuntimeException("Cliente não encontrado");
    }
}
