package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

import org.openqa.selenium.Keys;

/*revisar estos métodos métodos:

    driver.findElement()
    isDisplayed()
    getText()
    click()
    sendkeys()
    get()
*/


public class BasePage {


    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static By messageSave;

    static{
        System.setProperty( "webdriver.chrome.driver" , "./src/test/resources/chromedriver.exe" );
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver( chromeOptions );
        wait = new WebDriverWait( driver , 20 );
        messageSave = By.id( "egw_message" );
    }

    public BasePage ( WebDriver driver ){
        BasePage.driver = driver;
        wait = new WebDriverWait( driver , 20 );
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


        return find( locator ).getText();

    }

    public String getTextByLocator ( By locator ){

        return find( locator ).getText();

    }


    public void clickJs ( By locator ){

        WebElement waitUntil = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].click();" , waitUntil );


    }

    public String winHandles ( int posicionVentana ){

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

    public void enter ( By selector ){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(selector)).click();
        find( selector ).sendKeys( Keys.ENTER );
    }

    public void moveToElement ( By selector ){

        find( selector ).sendKeys( Keys.ARROW_DOWN );
    }


    //clic derecho = clic contextual
    public void clicRigth ( By locator ){

        WebElement b = find( locator );
        Actions action = new Actions( driver );
        action.contextClick( b ).build().perform();

    }

    public void clicRigthandMove ( By locator , By locatorMove ){

        WebElement b = find( locator );
        Actions action = new Actions( driver );
        action.contextClick( b ).build().perform();
        WebElement move = find( locatorMove );
        action.moveToElement( move );
        move.click();
    }

    public boolean messageIsDisplayed (){

        return find( messageSave ).isDisplayed();

    }

    public String messageGetText (){

        String mensaje = find( messageSave ).getText();
        click( messageSave );
        return mensaje;

    }

    public void dobleClick ( By locator ){

        Actions action = new Actions( driver );
        WebElement doblec = find( locator );
        action.doubleClick( doblec ).build().perform();

    }

    public void selectOption(By locator,String value){

        Select lista = new Select (find( locator ));
        lista.selectByValue(value  );

    }

}