package br.com.zup.calculadora.impostos.repository;

import br.com.zup.calculadora.impostos.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
}
