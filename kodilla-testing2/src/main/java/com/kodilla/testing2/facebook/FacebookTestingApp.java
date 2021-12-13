package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE_POLICY = "//*[@data-testid=\"cookie-policy-dialog-accept-button\"]";
    public static final String XPATH_OPEN_REGISTRATION = "//*[@data-testid=\"open-registration-form-button\"]";
    public static final String XPATH_BIRTHDAY_DAY = "//*[@name=\"birthday_day\"]";
    public static final String XPATH_BIRTHDAY_MONTH = "//*[@name=\"birthday_month\"]";
    public static final String XPATH_BIRTHDAY_YEAR = "//*[@name=\"birthday_year\"]";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while(!driver.findElement(By.xpath(XPATH_COOKIE_POLICY)).isDisplayed());
        driver.findElement(By.xpath(XPATH_COOKIE_POLICY)).click();
        driver.findElement(By.xpath(XPATH_OPEN_REGISTRATION)).click();

        Thread.sleep(1000);

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_BIRTHDAY_DAY));
        Select selectBoardDay = new Select(selectComboDay);
        selectBoardDay.selectByValue("27");

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_BIRTHDAY_MONTH));
        Select selectBoardMonth = new Select(selectComboMonth);
        selectBoardMonth.selectByValue("2");

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_BIRTHDAY_YEAR));
        Select selectBoardYear = new Select(selectComboYear);
        selectBoardYear.selectByValue("1974");
    }
}
