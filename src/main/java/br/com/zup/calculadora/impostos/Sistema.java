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

    public void executarSistema() {
        boolean continuar = true;

        while(continuar){
            menu();
            int resposta = IO.criarScanner().nextInt();

            if(resposta == 1){
                calcularValorLiquidoDoProdutoComICMS();
            }
        }

    }


    public void calcularValorLiquidoDoProdutoComICMS(){
        double total = valorProduto - calculoICMS.calcularImposto();
        IO.mostrarTexto("O valor líquido do produto é: " + total);
    }
}
