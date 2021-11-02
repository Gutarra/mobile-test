package com.tsoft.bot.mobile.helpers;

import com.tsoft.bot.both.utility.GenerateWord;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class HookMobile {
    private static String DeviceName;
    private static String UdId;
    private static String PlatformName = "Android";
    private static String PlatformVersion;
    private static String URLAppium = "http://127.0.0.1:4723/wd/hub";
    private static String appPackage = "";
    private static String appActivity = "";
    private static AppiumDriver<MobileElement> driver;

    private static GenerateWord generateWord;

    public static void setDeviceConfigurations(String deviceName, String udId, String platformName, String platformVersion)
    {
        DeviceName = deviceName;
        UdId = udId;
        if (!platformName.equals("")){
            PlatformName = platformName;
        }
        PlatformVersion = platformVersion;
    }
    public static void setAppConf(String apkAge, String apkAct)
    {
        appPackage = apkAge;
        appActivity = apkAct;
    }

    @Before
    public static void setUpMobile(Scenario scenario)
    {
        if (scenario.getName().contains("MOBILE"))
        {
            try{
                generateWord = new GenerateWord();
                generateWord.startUpWord(scenario.getName());
            }
            catch (Exception e){
                e.printStackTrace();
                generateWord.sendText("Error : Inicando reporte Word ." + e.getMessage());
            }
        }
    }
    @After
    public static void tearDown(io.cucumber.java.Scenario scenario) throws IOException {
        if (scenario.getName().contains("MOBILE"))
        {
            generateWord.endToWord(scenario.getStatus().toString());
        }
    }
    public static AppiumDriver<MobileElement> getDriver() {
        configureAppium();
        return driver;
    }

    public static void configureAppium()
    {
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName",DeviceName);
            capabilities.setCapability("udid",UdId);
            capabilities.setCapability("platformName",PlatformName);
            capabilities.setCapability("platformVersion",PlatformVersion);
            if (!appPackage.equals("")){
                capabilities.setCapability("appPackage",appPackage);
                capabilities.setCapability("appActivity",appActivity);
            }
            URL url = new URL(URLAppium);
            driver = new AppiumDriver<>(url, capabilities);
        }
        catch (Exception e){
            e.printStackTrace();
            generateWord.sendText("Error : Servidor Appium ." + e.getMessage());
        }
    }
}
