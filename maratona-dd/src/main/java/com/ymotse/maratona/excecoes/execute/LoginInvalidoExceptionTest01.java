package com.ymotse.maratona.excecoes.execute;

import com.ymotse.maratona.excecoes.dominio.LoginInvalidoException;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {

    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException {
        Scanner teclado = new Scanner(System.in);

        String usernameDB = "Goku";
        String passwordDB = "123";

        System.out.println("Usuario:");
        String usernameDigitado = teclado.nextLine();

        System.out.println("Senha:");
        String passwordDigitado = teclado.nextLine();

        if(!usernameDB.equals(usernameDigitado) || !passwordDB.equals(passwordDigitado)) {
            throw new LoginInvalidoException("Usuario ou senha invalido");
        }

        System.out.println("Usuario logado com sucesso!");
    }

}
