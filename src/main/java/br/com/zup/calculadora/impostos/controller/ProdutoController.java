package br.com.zup.calculadora.impostos.controller;

import br.com.zup.calculadora.impostos.entity.Cliente;
import br.com.zup.calculadora.impostos.entity.Produto;
import br.com.zup.calculadora.impostos.service.ClienteService;
import br.com.zup.calculadora.impostos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto){
      return produtoService.cadastrarProduto(produto);
    }

    //produtos/calcular/caneta/ICMS
    @GetMapping("calculo/{produto}/{imposto}/{nome}")
    public double calcularValorLiquido(@PathVariable String produto, @PathVariable String imposto, @PathVariable String cliente){
        Produto objProduto = produtoService.pesquisarProduto(produto);
        Cliente objCliente = clienteService.cadastrarCliente(cliente);

        return produtoService.calcularValorLiquido(objProduto, imposto, objCliente);
    }

    @GetMapping("{nome}/")
    public Produto pesquisarProduto(@PathVariable String nome){
        return produtoService.pesquisarProduto(nome);
    }
}
