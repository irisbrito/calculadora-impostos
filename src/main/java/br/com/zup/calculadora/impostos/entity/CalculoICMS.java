package br.com.zup.calculadora.impostos.entity;

public class CalculoICMS implements Tributavel {

    private double valorProduto;
    private double imposto = 0.18;

    @Override
    public double calcularImposto() {
        return valorProduto * imposto;
    }
}
