package com.tsoft.bot.mobile.scripts;

import com.tsoft.bot.mobile.base.MobileBaseClass;
import com.tsoft.bot.mobile.helpers.HookMobile;
import com.tsoft.bot.mobile.objects.MobileObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;

public class USSD extends MobileBaseClass {
    private static AppiumDriver<MobileElement> driver = HookMobile.getDriver();
    private String message = "inicio";

    public void goToKeyboard() throws IOException {
        try {
            if (isDisplayed(driver,MobileObjects.one)){
                click(driver,MobileObjects.keyboard);
                message = "ingresando a la marcación";
                generateWord.sendText(message);
                generateWord.addImageToWord(driver);
                addImageReport(driver,message);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    public void dialPhoneOrCodeUSSD(String ussd) throws IOException {
        try{
            awaitElement(driver,MobileObjects.dialButton);
            message = "marcando el código ussd";
            int x = 0;
            while (x < ussd.length())
            {
                dial(ussd.charAt(x));
                x++;
            }
            awaitElement(driver,MobileObjects.digits);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.dialButton);
        }catch (Exception e)
        {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }
    protected void dial(char digit) throws IOException {
        switch (digit) {
            case '1': click(driver,MobileObjects.one); break;
            case '2': click(driver,MobileObjects.two); break;
            case '3': click(driver,MobileObjects.three); break;
            case '4': click(driver,MobileObjects.four); break;
            case '5': click(driver,MobileObjects.five); break;
            case '6': click(driver,MobileObjects.six); break;
            case '7': click(driver,MobileObjects.seven); break;
            case '8': click(driver,MobileObjects.eight); break;
            case '9': click(driver,MobileObjects.nine); break;
            case '0': click(driver,MobileObjects.zero); break;
            case '*': click(driver,MobileObjects.star); break;
            case '#': click(driver,MobileObjects.pound); break;
        }
    }
    public void waitingResponse() throws IOException {
        try {
            message = "esperando la respueta";
            awaitElement(driver,MobileObjects.message);
            message += ", se encontro la respuesta";
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        } catch (Exception e) {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }

    public void waitMessage() throws IOException {
        try {
            awaitElement(driver,MobileObjects.finalMessage);
            message = "mensaje final";
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
        } catch (Exception e) {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
            throw e;
        }
    }

    public void sendPetitionCode(String petition)
    {
        try {
            awaitElement(driver,MobileObjects.input);
            message = "enviando código de petición";
            sendKeys(driver,MobileObjects.input,petition);
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.sendButton);
        } catch (Exception e) {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
        }
    }
    public void cancelPetitionCode(String petition)
    {
        try {
            message = "cancelando petición";
            generateWord.sendText(message);
            generateWord.addImageToWord(driver);
            addImageReport(driver,message);
            click(driver,MobileObjects.cancelButton);
        } catch (Exception e) {
            e.printStackTrace();
            generateWord.sendText("[ERROR] " + message);
        }
    }

}
