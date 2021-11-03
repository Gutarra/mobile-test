package com.tsoft.bot.mobile.base;

import com.tsoft.bot.both.utility.ExcelReader;
import com.tsoft.bot.both.utility.GenerateWord;
import com.tsoft.bot.both.utility.ScreenShot;
import com.tsoft.bot.mobile.helpers.HookMobile;
import com.tsoft.bot.mobile.objects.USSD.MobileExcelObjects;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MobileBaseClass {

    protected static GenerateWord generateWord = new GenerateWord();
    protected int row;
    protected List<HashMap<String, String>> deviceData;
    protected List<HashMap<String, String>> data;

    protected void awaitElement(AppiumDriver driver, By locator) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(locator ));
        }catch (RuntimeException we){
            errorNoElementFound(driver,locator);
            throw we;
        }
    }
    protected boolean isDisplayed(AppiumDriver driver, By locator) throws IOException {
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (RuntimeException we){
            errorNoElementFound(driver,locator);
            throw we;
        }
    }
    protected void click(AppiumDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).click();
        }catch (RuntimeException we){
            errorNoElementFound(driver,locator);
            throw we;
        }
    }
    protected void sendKeys(AppiumDriver driver, By locator,String text) throws IOException {
        try {
            driver.findElement(locator).sendKeys(text);
        }catch (RuntimeException we){
            errorNoElementFound(driver,locator);
            throw we;
        }
    }
    protected void click(WebDriver driver, By locator, int index) throws IOException {
        try {
            driver.findElements(locator).get(index).click();
        }catch (RuntimeException we){
            //errorNoElementFound(driver);
            throw we;
        }
    }
    protected void errorNoElementFound(AppiumDriver driver, By locator) throws IOException {
        System.out.println("no element found, by locator" + locator.toString());
        generateWord.addImageToWord(driver);
        generateWord.sendText("element not found " + locator.toString());
    }
    public String get(String col){ return data.get(row).get(col); }
    public void setExcel(String ruta, String test) throws Exception {
        deviceData = ExcelReader.data(ruta,MobileExcelObjects.DEVICE_PAGE);
        data = ExcelReader.data(ruta,MobileExcelObjects.DATA_PAGE);
        row = Integer.parseInt(test) - 1;
    }
    public void setDevice()
    {
        HookMobile.setDeviceConfigurations(
                deviceData.get(row).get(MobileExcelObjects.DEVICE_NAME),
                deviceData.get(row).get(MobileExcelObjects.UDID),
                deviceData.get(row).get(MobileExcelObjects.PLATFORM_NAME),
                deviceData.get(row).get(MobileExcelObjects.PLATFORM_VERSION)
        );
        HookMobile.setAppConf(
                deviceData.get(row).get(MobileExcelObjects.APP_PACKAGE),
                deviceData.get(row).get(MobileExcelObjects.APP_ACTIVITY)
        );
    }
    protected void addImageReport(AppiumDriver driver,String title)
    {
        try
        {
            Serenity.recordReportData().withTitle(title).downloadable().fromFile(ScreenShot.takeScreenShoot(driver));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
