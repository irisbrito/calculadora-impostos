package br.com.zup.calculadora.impostos.entity;

public class CalculoPIS implements Tributavel {

    private double valorProduto;
    private double imposto = 0.0065;

    @Override
    public double calcularImposto() {
        return valorProduto * imposto;
    }

}
