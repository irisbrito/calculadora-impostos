package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.*;
import br.com.zup.calculadora.impostos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteService clienteService;

    private double valorLiquido;
    private List<Produto> produtos = new ArrayList<>();

    Tributavel calculoCofins = new CalculoCofins();
    Tributavel calculoICMS = new CalculoICMS();
    Tributavel calculoPIS = new CalculoPIS();

    public Produto cadastrarProduto(Produto produto){
       return produtoRepository.save(produto);
    }

    public Produto pesquisarProduto(String nome){
        for(Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public Iterable<Produto> pesquisarTodosOsProdutos(){
        return produtoRepository.findAll();
    }

    public double calcularValorLiquido(Produto produto, String imposto){

        double impostoCalculado;


        if(imposto.equalsIgnoreCase("ICMS")){
            impostoCalculado = calculoICMS.calcularImposto();
            valorLiquido = produto.getPreco() - impostoCalculado;
        }
        else if(imposto.equalsIgnoreCase("PIS")){
            impostoCalculado = calculoPIS.calcularImposto();
            valorLiquido = produto.getPreco() - impostoCalculado;

        } else if(imposto.equalsIgnoreCase("Cofins")){
            impostoCalculado = calculoCofins.calcularImposto();
            valorLiquido = produto.getPreco() - impostoCalculado;
        }

        validarDescontoDoValorLiquido(produto);
        //validarDescontoClientePreferencial(cliente);

        return valorLiquido;
    }

    public void validarDescontoDoValorLiquido(Produto produto){
        if(produto.getTipoDeProduto() == TipoDeProduto.PRODUTO_ACABADO){
            valorLiquido = valorLiquido - (valorLiquido / 100);
        }
    }

    public void validarDescontoClientePreferencial(Cliente cliente){
        if(cliente.getTipoDeCliente() == TipoDeCliente.PREFERENCIAL){
            valorLiquido = valorLiquido - (valorLiquido * 0.005);
        }
    }

    public void deletarProduto(int id){
        produtoRepository.deleteById(id);
    }

}
