package br.com.zup.calculadora.impostos.repository;

import br.com.zup.calculadora.impostos.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
