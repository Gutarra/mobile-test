package steps;


import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.MovistarPage;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

public class MovistarWebSteps {
    MovistarPage page = new MovistarPage(Hook.getDriver());
    @Dado("que se tienen los datos para el {string} de prueba")
    public void queSeTienenLosDatosParaElDePrueba(String dato) throws Exception {
        page.setExcelData(dato);
    }

    @Cuando("ingresa a la página")
    public void ingresaALaPagina() throws Exception {
        page.toHomePage();
    }

    @Y("seleciona uno de los duos")
    public void selecionaUnoDeLosDuos() throws Exception {
        page.selectDuo();
    }

    @Entonces("revisa la información de los planes")
    public void revisaLaInformacionDeLosPlanes() throws Exception {
        page.viewPlansInformation();
    }

    @Y("mira los terminos y condiciones")
    public void miraLosTerminosYCondiciones() throws Exception {
        page.viewTermsAndConditions();
    }

    @Y("seleciona uno de los trios")
    public void selecionaUnoDeLosTrios() throws Exception {
        page.selectTrio();
    }
}
