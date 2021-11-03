package steps;

import com.tsoft.bot.mobile.objects.MovistarApp.MobileExcelObjects;
import com.tsoft.bot.mobile.scripts.MovistarApp;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Dado;

import java.io.IOException;

public class MovistarAppSteps extends MovistarApp {
    @Dado("que se tiene un archivo {string} con el {string}")
    public void queSeTieneUnArchivoConEl(String file, String testcase) throws Exception {
        setExcel(file,testcase);
    }

    @Cuando("Ingresamos en empezar ahora")
    public void ingresamosEnEmpezarAhora() throws IOException {
        goToStart();
    }

    @Y("ingresamos con todos los productos")
    public void ingresamosConTodosLosProductos() throws IOException {
        signInWithAllProducts(get(MobileExcelObjects.DNI),get(MobileExcelObjects.PASSWORD));
    }

    @Entonces("consultamos la primera linea personal")
    public void conultamosLaPrimeraLineaPersonal() throws IOException {
        viewPersonalLine();
    }

    @Y("revisamos los detalles de la linea")
    public void revisamosLosDetallesDeLaLinea() throws IOException {
        viewPersonalLine();
    }

    @Y("volvemos al inicio")
    public void volvemosAlInicio() throws IOException {
        backToHome();
    }

    @Entonces("ingresamos al perfil")
    public void ingresamosAlPerfil() throws IOException {
        goToProfile();
    }

    @Y("cerramos session")
    public void cerramosSession() throws IOException {
        signOut();
    }

    @Y("abrimos la aplicación de Movistar")
    public void abrimosLaAplicaciónDeMovistar() {
        setDevice();
    }
}
