package com.ymotse.maratona.padroesdeprojeto.execute;

import com.ymotse.maratona.padroesdeprojeto.dominio.Country;
import com.ymotse.maratona.padroesdeprojeto.dominio.Currency;
import com.ymotse.maratona.padroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
