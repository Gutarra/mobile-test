package steps;

import com.tsoft.bot.mobile.objects.MobileExcelObjects;
import com.tsoft.bot.mobile.scripts.USSD;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import java.io.IOException;

public class USSDSteps extends USSD {
    @Dado("que se proporciona un archivo {string} con el {string} para la prueba ussd")
    public void queSeProporcionaUnArchivoConElParaLaPruebaUssd(String ruta, String dato) throws Exception {
        setExcel(ruta,dato);
        setDevice();
    }

    @Cuando("marcamos el código USSD")
    public void marcamosElCodigoUSSD() throws IOException {
        dialPhoneOrCodeUSSD(get(MobileExcelObjects.USSD_CODE));
    }

    @Entonces("esperamos la respuesta")
    public void esperamosLaRespuesta() throws IOException {
        waitingResponse();
    }

    @Y("enviamos la primera petición")
    public void enviamosLaPrimeraPeticion() {
        sendPetitionCode(get(MobileExcelObjects.DO_YOU_NEED));
    }

    @Y("vamos a la marcación")
    public void vamosALaMarcacion() throws IOException {
        goToKeyboard();
    }

    @Y("consultamos mi prepado")
    public void consultamosMiPrepado() {
        sendPetitionCode(get(MobileExcelObjects.DO_YOU_NEED));
    }

    @Y("selecionamos una de las opciones para consultar")
    public void selecionamosUnaDeLasOpcionesParaConsultar() {
        sendPetitionCode(get(MobileExcelObjects.BEST_OPTIONS));
    }

    @Y("Eperamos la respuesta final")
    public void eperamosLaRespuestaFinal() throws IOException {
        waitMessage();
    }
}
