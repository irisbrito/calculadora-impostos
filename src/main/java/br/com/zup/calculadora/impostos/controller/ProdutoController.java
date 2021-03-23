package br.com.zup.calculadora.impostos.controller;

import br.com.zup.calculadora.impostos.entity.Produto;
import br.com.zup.calculadora.impostos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public Produto cadastrarProduto(Produto produto){
      return produtoService.cadastrarProduto(produto);
    }
}
