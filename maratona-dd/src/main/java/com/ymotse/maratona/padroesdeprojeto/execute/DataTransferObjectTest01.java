package com.ymotse.maratona.padroesdeprojeto.execute;

import com.ymotse.maratona.padroesdeprojeto.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder.builder().firstName("John").lastName("Scott").build();

        ReportDto reportDto = ReportDto.ReportDtoBuilder.builder().aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(person.getFirstName())
                .build();

        System.out.println(reportDto);

    }
}
