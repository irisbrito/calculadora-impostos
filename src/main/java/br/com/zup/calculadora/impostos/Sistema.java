package br.com.zup.calculadora.impostos;

public class Sistema {

    CalculoCofins calculoCofins = new CalculoCofins();
    CalculoICMS calculoICMS = new CalculoICMS();
    CalculoPIS calculoPIS = new CalculoPIS();
    double valorProduto;

    public void menu(){
        IO.mostrarTexto("Saiba o valor líquido do produto");
        IO.mostrarTexto("Digite o valor do produto");
        valorProduto = IO.criarScanner().nextDouble();
        IO.mostrarTexto("Escolha o imposto: 1 - ICMS \n 2 - PIS \n 3 - Cofins");
    }


}
