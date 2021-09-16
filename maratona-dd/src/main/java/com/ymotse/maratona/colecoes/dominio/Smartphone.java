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
    
    // Se x.equals(y) == TRUE, y.hashCode() == x.hashCode()
    // y.hashCode() == x.hashCode() nao necessariamente a equals de y.equals(x) tem que ser TRUE
    // x.equals(y) == FALSE
    // y.hashCode() != x.hashCode() x.equals(y) devera ser FALSE.
    @Override
    public int hashCode() {
    	return serialNumber == null ? 0 : this.serialNumber.hashCode();
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