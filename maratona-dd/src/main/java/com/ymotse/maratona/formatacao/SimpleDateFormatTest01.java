package com.ymotse.maratona.formatacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {

    public static void main(String[] args) {
        String pattern = "yyyy.MM.dd G 'at' HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(new Date()));

        try {
            System.out.println(simpleDateFormat.parse("2021.08.27 d.C. at 18:55:28 BRT"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(new SimpleDateFormat("'São Paulo,' dd 'de' MMMM 'de' yyyy").format(new Date()));
    }

}
