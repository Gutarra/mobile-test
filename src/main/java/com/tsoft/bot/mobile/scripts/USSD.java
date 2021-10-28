package com.tsoft.bot.mobile.scripts;

import com.tsoft.bot.mobile.base.MobileBaseClass;
import com.tsoft.bot.mobile.helpers.HookMobile;
import com.tsoft.bot.mobile.objects.MobileObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class USSD extends MobileBaseClass {
    private final AppiumDriver<MobileElement> driver = HookMobile.getDriver("MOBILE USSD");;

    public void startPhone() throws IOException {
        click(driver, MobileObjects.phone,MobileObjects.phone_position);
    }
}
