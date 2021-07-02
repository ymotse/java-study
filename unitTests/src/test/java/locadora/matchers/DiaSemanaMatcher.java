package locadora.matchers;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import locadora.utils.DataUtils;

public class DiaSemanaMatcher extends TypeSafeMatcher<Date> {

    private Integer diaSemana;
    
    public DiaSemanaMatcher(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }
    
    @Override
    public void describeTo(Description description) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_WEEK, diaSemana);
        String dataExtenso = date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("pt-BR"));
        description.appendText(dataExtenso);
    }

    @Override
    protected boolean matchesSafely(Date data) {
        return DataUtils.verificarDiaSemana(data, diaSemana);
    }

}
