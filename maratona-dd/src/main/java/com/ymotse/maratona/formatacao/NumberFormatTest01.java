package com.ymotse.maratona.formatacao;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest01 {

    public static void main(String[] args) {

        Locale localeDefault = Locale.getDefault();
        Locale localeBR = new Locale("pt", "BR");
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALIAN;
        Locale localeUS = Locale.US;

        NumberFormat[] nfa = new NumberFormat[5];
        nfa[0] = NumberFormat.getInstance();
        nfa[2] = NumberFormat.getInstance(localeJP);
        nfa[1] = NumberFormat.getInstance(localeBR);
        nfa[3] = NumberFormat.getInstance(localeIT);
        nfa[4] = NumberFormat.getInstance(localeUS);
        double valor = 10_000.2130;

        for (NumberFormat numberFormat : nfa) {
            numberFormat.setMaximumFractionDigits(2);
            System.out.println(numberFormat.format(valor));
        }

        String valorString = "1000.2130";
        try {
            System.out.println(nfa[4].parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
