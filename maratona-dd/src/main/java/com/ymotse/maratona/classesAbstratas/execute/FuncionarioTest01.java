package com.ymotse.maratona.classesAbstratas.execute;

import com.ymotse.maratona.classesAbstratas.dominio.Desenvolvedor;
import com.ymotse.maratona.classesAbstratas.dominio.Gerente;

public class FuncionarioTest01 {

    public static void main(String[] args) {
        Gerente gerente1 = new Gerente("Nami", 5000);
        Desenvolvedor dev1 = new Desenvolvedor("Touya", 12000);

        System.out.println(gerente1);
        System.out.println(dev1);
    }

}
