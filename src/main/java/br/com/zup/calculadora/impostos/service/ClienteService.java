package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.Cliente;
import br.com.zup.calculadora.impostos.entity.Produto;
import br.com.zup.calculadora.impostos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> pesquisarCliente (String cpf){
        return clienteRepository.findById(cpf);
    }

}
