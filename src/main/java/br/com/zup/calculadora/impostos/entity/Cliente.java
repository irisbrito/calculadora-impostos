package br.com.zup.calculadora.impostos.entity;

public class Cliente {

    private String nome;
    private String cpf;
    private TipoDeCliente tipoDeCliente;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(TipoDeCliente tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }
}
