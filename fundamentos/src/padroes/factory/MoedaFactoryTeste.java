package padroes.factory;

public class MoedaFactoryTeste {

    public static void main(String[] args) {

        Moeda moeda = MoedaFactory.criarMoeda(Pais.BRASIL);
        System.out.println(moeda.getSimbolo());
    }

}
