package com.ymotse.maratona.heranca.dominio;

public class Funcionario extends Pessoa {
    private double salario;

    static {
        System.out.println("Dentro do bloco de inicialização estatico de Funcionario");
    }
    {
        System.out.println("Dentro do bloco de inicialização de Funcionario 01");
    }
    {
        System.out.println("Dentro do bloco de inicialização de Funcionario 02");
    }

    public Funcionario(String nome) {
        super(nome);
        System.out.println("Dentro do Construtor de Funcionario");
    }

    public void imprimir() {
        super.imprimir();
        System.out.println(this.salario);
    }

    public void relatorioPagamento() {
        System.out.println("Eu " + this.nome + " recebi o salario de " + this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
