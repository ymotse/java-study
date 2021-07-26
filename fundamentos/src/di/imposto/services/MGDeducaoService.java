package di.imposto.services;

public class MGDeducaoService implements DeducaoService {

    @Override
    public double deducao(double valor) {
        return valor * 0.12;
    }

}
