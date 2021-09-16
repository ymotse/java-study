package com.ymotse.maratona.colecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    // Reflexivo: x.equals(x) tem que ser TRUE para tudo que for diferente de NULL
    // Simetrico: para x e y diferentes de NULL, se x.equals(y) == TRUE, logo, y.equals(x) == TRUE
    // Transitividade: para x,y,z diferentes de NULL, se x.equals(y) == true, e y.equals(z) == TRUE, logo y.equals(z) == TRUE
    // Consistente: x.equals(x) sempre retorna TRUE se x for diferente de NULL
    // para x diferente de NULL, x.equals(NULL) tem que retornar FALSE.
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}