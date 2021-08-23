package com.ymotse.maratona.heranca.dominio;

public class Funcionario extends Pessoa {
    private double salario;

    public void imprimir() {
        super.imprimir();
        System.out.println(this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
