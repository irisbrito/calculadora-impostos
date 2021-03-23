package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    Tributavel calculoCofins = new CalculoCofins();
    Tributavel calculoICMS = new CalculoICMS();
    Tributavel calculoPIS = new CalculoPIS();

    public Produto cadastrarProduto(Produto produto){
        produtos.add(produto);

        return produto;
    }

}
