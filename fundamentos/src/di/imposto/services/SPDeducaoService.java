package di.imposto.services;

public class SPDeducaoService implements DeducaoService {

    @Override
    public double deducao(double valor) {
        return valor * 0.10;
    }

}
