package steps;

import com.tsoft.bot.mobile.scripts.USSD;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import java.io.IOException;

public class USSDSteps extends USSD {
    @Dado("que se proporciona un archivo {string} con el {string} para la prueba ussd")
    public void queSeProporcionaUnArchivoConElParaLaPruebaUssd(String ruta, String dato) throws Exception {
        setExcel(ruta,dato);
        setDevice();
    }

    @Cuando("iniciamos el teléfono")
    public void iniciamosElTelefono() throws IOException {
        startPhone();
    }
}
