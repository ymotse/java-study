package com.ymotse.maratona.heranca.dominio;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;

    static {
        System.out.println("Dentro do bloco de inicialização estatico de Pessoa");
    }
    {
        System.out.println("Dentro do bloco de inicialização de Pessoa 01");
    }
    {
        System.out.println("Dentro do bloco de inicialização de Pessoa 02");
    }

    public Pessoa(String nome) {
        System.out.println("Dentro do Construtor de Pessoa");
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf) {
        this(nome);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void imprimir() {
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.endereco.getRua() + " : " + this.endereco.getCep() + "\n");
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
