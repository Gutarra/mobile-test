package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.both.utility.ExcelReader;
import com.tsoft.bot.both.utility.GenerateWord;
import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.MovistarExcelObjects;
import com.tsoft.bot.frontend.objects.MovistarObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MovistarPage extends BaseClass {
    private static GenerateWord generateWord = new GenerateWord();
    private String message;
    private int test;
    protected WebDriver driver;
    private List<HashMap<String, String>> data;

    public void setExcelData(String test) throws Exception {
        data = ExcelReader.data(MovistarExcelObjects.EXCEL_RUTA, MovistarExcelObjects.PAGE);
        this.test = Integer.parseInt(test) - 1;
    }
    private String getData(String column)
    {
        return data.get(test).get(column);
    }

    public MovistarPage(WebDriver driver) {
        super(driver);
        this.driver = Hook.getDriver();
    }

    public void toHomePage() throws Exception {
        message = "Se ingresa a la página de inicio";
        try
        {
            String url = getData(MovistarExcelObjects.COLUMN_URL);
            this.driver.get(url);
            stepPass(driver, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(MovistarExcelObjects.EXCEL_RUTA, MovistarExcelObjects.PAGE, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

    public void selectDuo() throws Exception {
        message = "seleciona uno de los duos";
        try
        {
            Random random = new Random();
            switch (random.nextInt(3) + 1)
            {
                case 1: click(driver,MovistarObjects.duo_it); break;
                case 2: click(driver,MovistarObjects.duo_if); break;
                case 3: click(driver,MovistarObjects.duo_tf); break;
            }
            awaitFor(driver,MovistarObjects.termAndConditions);
            stepPass(driver, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(MovistarExcelObjects.EXCEL_RUTA, MovistarExcelObjects.PAGE, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }
    public void selectTrio() throws Exception {
        message = "seleciona uno de los trios";
        try
        {
            click(driver,MovistarObjects.trio);
            awaitFor(driver,MovistarObjects.termAndConditions);
            stepPass(driver, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(MovistarExcelObjects.EXCEL_RUTA, MovistarExcelObjects.PAGE, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

    public void viewPlansInformation() throws Exception {
        message = "vista general de los planes por producto";
        try
        {
            scroll(driver,0,-10000);
            scroll(driver,0,500);
            stepPass(driver, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(MovistarExcelObjects.EXCEL_RUTA, MovistarExcelObjects.PAGE, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

    public void viewTermsAndConditions() throws Exception {
        message = "visualizamos los terminos y condiciones";
        try
        {
            click(driver,MovistarObjects.termAndConditions);
            scroll(driver,0,-10000);
            scroll(driver,0,1470);
            stepPass(driver, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(MovistarExcelObjects.EXCEL_RUTA, MovistarExcelObjects.PAGE, 1, 19, "FAIL");
            stepFail(driver,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(driver);
        }
    }

    protected void awaitFor(WebDriver driver, By locator) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

}
