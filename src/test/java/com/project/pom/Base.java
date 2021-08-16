package com.project.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;


public class Base {


    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty( "webdriver.chrome.driver" , "./src/test/resources/chromedriver.exe" );
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver( chromeOptions );
        wait = new WebDriverWait( driver , 10 );
    }

    public Base ( WebDriver driver ){
        Base.driver = driver;
        wait = new WebDriverWait( driver , 10 );
    }

    public static void navigateTo ( String url ){

        driver.get( url );

    }

    public static void closedBrowser (){

        driver.quit();
    }

    private WebElement find ( By locator ){

        WebElement waitUntil = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        return waitUntil;


    }


    public void write ( By locator , String textToWrite ){
        find( locator ).clear();
        find( locator ).sendKeys( textToWrite );

    }


    public void click ( By locator ){

        WebElement waitUntil = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        waitUntil.click();

    }


    public String getText ( By locator ){

        WebElement waitUntil = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        return waitUntil.getText();

    }

    public String getTextByLocator ( By locator ){

        return find( locator ).getText();

    }


    public void scroll ( By locator ){

        WebElement waitUntil = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].scrollIntoViewIfNeeded();" , waitUntil );
    }

    public String VentanasHandles ( int posicionVentana ){

        Set<String> ventanas = driver.getWindowHandles();
        return (String) ventanas.toArray()[ posicionVentana ];

    }

    public String getTitulo (){

        return driver.getTitle();
    }

    public void switchToVentana ( String IdVentana ){

        driver.switchTo().window( IdVentana );

    }

    public boolean elementIsDisplayed ( By locator ){


        return find( locator ).isDisplayed();


    }
}