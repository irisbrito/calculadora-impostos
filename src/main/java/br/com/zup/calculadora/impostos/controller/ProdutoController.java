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

    private ProdutoService produtoService;
    private ClienteService clienteService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, ClienteService clienteService) {
        this.produtoService = produtoService;
        this.clienteService = clienteService;
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto){
      return produtoService.cadastrarProduto(produto);
    }

    //produtos/calcular/caneta/ICMS
    @GetMapping("calculo/{produto}/{imposto}/{nome}")
    public double calcularValorLiquido(@PathVariable String produto, @PathVariable String imposto){
        Produto objProduto = produtoService.pesquisarProduto(produto);
       //Cliente objCliente = clienteService.cadastrarCliente(cliente);

        return produtoService.calcularValorLiquido(objProduto, imposto);
    }

    @GetMapping("{nome}/")
    public Produto pesquisarProduto(@PathVariable String nome){
        return produtoService.pesquisarProduto(nome);
    }

    @DeleteMapping
    public void deletarProduto(@PathVariable int id){
        produtoService.deletarProduto(id);
    }
}
