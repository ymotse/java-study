package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Calendar;

public class EncodeDecodePDF {

    public static void main(String[] args) throws IOException {

        Path diretorioDoProjeto = Paths.get("");
        String diretorio = diretorioDoProjeto.toAbsolutePath().normalize().toString();

        File arquivoNaoDecodificado = new File(diretorio + File.separator + "arquivo.pdf");


        //----- Encode file:
        byte[] arquivoEmBytes = Files.readAllBytes(Paths.get(arquivoNaoDecodificado.getAbsolutePath()));
        byte[] arquivoCodificadoEmBase64 = Base64.getEncoder().encode(arquivoEmBytes);

        String arquivoBase64EmString = new String(arquivoCodificadoEmBase64, StandardCharsets.UTF_8);
        System.out.println("Arquivo Codificado: \n"+arquivoBase64EmString);


        //----- Decode file:
        FileOutputStream fos = new FileOutputStream(diretorio + File.separator + "decoded_file_" + Calendar.getInstance().getTime().getTime() + ".pdf");

        byte[] arquivoEmBase64ParaDecodificar = Base64.getDecoder().decode(arquivoCodificadoEmBase64);
        fos.write(arquivoEmBase64ParaDecodificar);
        fos.flush();
        fos.close();
    }

}
