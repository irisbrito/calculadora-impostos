package br.com.zup.calculadora.impostos.service;

import br.com.zup.calculadora.impostos.entity.CalculoCofins;
import br.com.zup.calculadora.impostos.entity.CalculoICMS;
import br.com.zup.calculadora.impostos.entity.CalculoPIS;
import br.com.zup.calculadora.impostos.entity.Tributavel;
import br.com.zup.calculadora.impostos.service.IO;

public class Sistema {

    Tributavel calculoCofins = new CalculoCofins();
    Tributavel calculoICMS = new CalculoICMS();
    Tributavel calculoPIS = new CalculoPIS();
    double valorProduto;

    public void menu(){
        IO.mostrarTexto("Saiba o valor líquido do produto");
        IO.mostrarTexto("Digite o valor do produto");
        valorProduto = IO.criarScanner().nextDouble();
        IO.mostrarTexto("Escolha o imposto: 1 - ICMS \n 2 - PIS \n 3 - Cofins");
    }

    public void executarSistema() {
        boolean continuar = true;

        while(continuar){
            menu();
            int resposta = IO.criarScanner().nextInt();

            if(resposta == 1){
                calcularValorLiquidoDoProduto(calculoICMS);
            }
            if(resposta == 2){
                calcularValorLiquidoDoProduto(calculoPIS);
            }
            if(resposta == 3){
                calcularValorLiquidoDoProduto(calculoCofins);
            }
        }

    }


    public void calcularValorLiquidoDoProduto(Tributavel calculo){
        double total = valorProduto - calculo.calcularImposto();
        IO.mostrarTexto("O valor líquido do produto é: " + total);
    }
}
