package com.tsoft.bot.mobile.base;

import com.tsoft.bot.both.utility.ExcelReader;
import com.tsoft.bot.both.utility.GenerateWord;
import com.tsoft.bot.mobile.helpers.HookMobile;
import com.tsoft.bot.mobile.objects.MobileExcelObjects;
import io.appium.java_client.AppiumDriver;
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
            WebDriverWait wait = new WebDriverWait(driver, 10000);
            wait.until(ExpectedConditions.elementToBeClickable(locator ));
        }catch (RuntimeException we){
            errorNoElementFound(driver);
            throw we;
        }
    }
    protected void click(AppiumDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).click();
        }catch (RuntimeException we){
            errorNoElementFound(driver);
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
    protected void errorNoElementFound(AppiumDriver driver) throws IOException {
        driver.close();
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
    }
}