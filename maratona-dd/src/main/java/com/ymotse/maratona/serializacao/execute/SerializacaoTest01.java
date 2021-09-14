package com.ymotse.maratona.serializacao.execute;

import com.ymotse.maratona.serializacao.dominio.Aluno;
import com.ymotse.maratona.serializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(1L, "William Suane", "12324436778");
        Turma turma = new Turma("Maratona Java Virado no Jiraya");
        aluno1.setTurma(turma);

        serializar(aluno1);
        deserializar();
    }

    private static void serializar(Aluno aluno) {
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(aluno);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializar() {
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectInputStream oos = new ObjectInputStream(Files.newInputStream(path))) {
            Aluno aluno = (Aluno) oos.readObject();
            System.out.println(aluno);
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
