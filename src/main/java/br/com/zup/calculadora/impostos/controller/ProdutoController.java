package br.com.zup.calculadora.impostos.controller;

import br.com.zup.calculadora.impostos.entity.Produto;
import br.com.zup.calculadora.impostos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto){
      return produtoService.cadastrarProduto(produto);
    }

    //produtos/calcular/caneta/ICMS
    @GetMapping("calculo/{produto}/{imposto}/")
    public double calcularValorLiquido(@PathVariable String produto, @PathVariable String imposto){
        Produto objProduto = produtoService.pesquisarProduto(produto);

        return produtoService.calcularValorLiquido(objProduto, imposto);
    }
}
