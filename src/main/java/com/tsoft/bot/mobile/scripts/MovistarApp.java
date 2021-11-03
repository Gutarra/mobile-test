package com.tsoft.bot.mobile.scripts;

import com.tsoft.bot.mobile.base.MobileBaseClass;
import com.tsoft.bot.mobile.helpers.HookMobile;
import com.tsoft.bot.mobile.objects.MovistarApp.MobileObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

public class MovistarApp extends MobileBaseClass {
    private static AppiumDriver<MobileElement> driver;
    private String message = "";

    public void goToStart() throws IOException {
        try {
            driver = HookMobile.getDriver();
            awaitElement(driver,MobileObjects.startNow);
            message = "iniciando la applicación";
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.startNow);
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void signInWithAllProducts(String doc,String password) throws IOException {
        try {
            message = "ingresando a ver todos los productos";
            awaitElement(driver,MobileObjects.signinByAllProducts_B);
            click(driver,MobileObjects.signinByAllProducts_B);
            awaitElement(driver,MobileObjects.inputDocument);
            click(driver,MobileObjects.inputDocument);
            sendKeys(driver,MobileObjects.inputDocument,doc);
            awaitElement(driver,MobileObjects.getInto);
            click(driver,MobileObjects.getInto);
            awaitElement(driver,MobileObjects.inputPassword);
            click(driver,MobileObjects.inputPassword);
            sendKeys(driver,MobileObjects.inputPassword,password);
            //driver.navigate().back();
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            awaitElement(driver,MobileObjects.btnGetInto);
            click(driver,MobileObjects.btnGetInto);
            // click(driver,MobileObjects.signinButton);
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void viewPersonalLine() throws IOException {
        try {
            message = "ingresando a ver detalles de la linea personal";
            System.out.println("ingresando a Home");
            // awaitElement(driver,MobileObjects.home);
            closeAds();
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.personalLineOne);
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void viewDetails() throws IOException {
        try {
            message = "Revisando detalles de la linea personal";
            awaitElement(driver,MobileObjects.idLine);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.home);
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void backToHome() throws IOException {
        try {
            message = "regresando al inicio";
            awaitElement(driver,MobileObjects.personalLineOne);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void goToProfile() throws IOException {
        try {
            awaitElement(driver,MobileObjects.profileButton);
            click(driver,MobileObjects.profileButton);
            message = "Ingresando a la página de perfil";
            awaitElement(driver,MobileObjects.profileName);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void signOut() throws IOException {
        try {
            click(driver,MobileObjects.closeSession);
            message = "cerrando sessión";
            // awaitElement(driver,MobileObjects.profileName);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            message = "confirmando, y cerrando sessión";
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.confirmClose);
            awaitElement(driver,MobileObjects.startNow);

        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    protected void closeAds() throws IOException {
        System.out.println("cerrando ads");
        awaitElement(driver,MobileObjects.closeAdd);
        click(driver,MobileObjects.closeAdd);
    }
}
