package com.tsoft.bot.mobile.objects;

import org.openqa.selenium.By;

public class MobileObjects {
    public static By phone = By.className("android.widget.TextView");
    public static int phone_position = 0;
    public static By keyboard = By.className("android.widget.LinearLayout");
    public static int keyboard_position = 0;

    /* requires mapping phone */
    public static By one = By.className("com.samsung.android.dialer:id/one");
    public static By two = By.className("com.samsung.android.dialer:id/two");
    public static By three = By.className("com.samsung.android.dialer:id/three");
    public static By four = By.className("com.samsung.android.dialer:id/four");
    public static By five = By.className("com.samsung.android.dialer:id/five");
    public static By six = By.className("com.samsung.android.dialer:id/six");
    public static By seven = By.className("com.samsung.android.dialer:id/seven");
    public static By eight = By.className("com.samsung.android.dialer:id/eight");
    public static By nine = By.className("com.samsung.android.dialer:id/nine");
    public static By zero = By.className("com.samsung.android.dialer:id/zero");

    public static By star = By.className("com.samsung.android.dialer:id/star");
    public static By pound = By.className("com.samsung.android.dialer:id/pound");
}
