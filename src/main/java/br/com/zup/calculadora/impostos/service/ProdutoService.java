package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private double valorLiquido;
    private List<Produto> produtos = new ArrayList<>();

    Tributavel calculoCofins = new CalculoCofins();
    Tributavel calculoICMS = new CalculoICMS();
    Tributavel calculoPIS = new CalculoPIS();

    public Produto cadastrarProduto(Produto produto){
        produtos.add(produto);

        return produto;
    }

    public Produto pesquisarProduto(String nome){
        for(Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
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

        return valorLiquido;
    }

    public void validarDescontoDoValorLiquido(Produto produto){
        if(produto.getTipoDeProduto() == TipoDeProduto.PRODUTO_ACABADO){
            valorLiquido = valorLiquido - (valorLiquido / 100);
        }
    }

}
