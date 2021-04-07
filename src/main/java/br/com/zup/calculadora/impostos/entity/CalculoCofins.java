package br.com.zup.calculadora.impostos.entity;

public class CalculoCofins implements Tributavel {

    private double valorProduto;
    private double imposto = 0.03;

    @Override
    public double calcularImposto() {
        return valorProduto * imposto;
    }
}
