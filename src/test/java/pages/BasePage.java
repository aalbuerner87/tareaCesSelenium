package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

import properties.*;


public class BasePage {


    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static By messageSave;


    static{

       ConfigProperties browser=new ConfigProperties();
       String browserType= browser.getBrowser();
        if(browserType.equalsIgnoreCase( "chrome" )){

            System.setProperty( "webdriver.chrome.driver" , "./src/test/resources/chromedriver.exe" );
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver( chromeOptions );


           } else if(browserType.equalsIgnoreCase( "edge" )){

            System.setProperty( "webdriver.edge.driver" , "./src/test/resources/msedgedriver.exe" );
            EdgeOptions edgeOptions = new EdgeOptions();
            driver = new EdgeDriver( edgeOptions );
        }

        wait = new WebDriverWait( driver , 20 );
        messageSave = By.id( "egw_message" );
    }

    public BasePage ( WebDriver driver ){
        BasePage.driver = driver;
        wait = new WebDriverWait( driver , 20 );
    }


    public static void navigateTo ( String url ){

        driver.manage().window().maximize();
        driver.get( url );

    }

    public static void closedBrowser (){

        driver.close();
    }

    private WebElement find ( By locator ){

        WebElement elementWithWait = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        return elementWithWait;


    }


    public void write ( By locator , String textToWrite ){
        find( locator ).clear();
        find( locator ).sendKeys( textToWrite );

    }


    public void click ( By locator ){

        find( locator ).click();


    }


    public String getText ( By locator ){


        return find( locator ).getText();

    }

    public void clickJs ( By locator ){

        WebElement waitUntil = wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].click();" , waitUntil );


    }

    public String winHandles ( int positionWindow ){

        Set<String> windows = driver.getWindowHandles();
        return (String) windows.toArray()[ positionWindow ];

    }

    public String getTitle (){

        return driver.getTitle();
    }

    public void switchToVentana ( String IdVentana ){

        driver.switchTo().window( IdVentana );

    }

    public boolean elementIsDisplayed   ( By locator ){

        boolean dis=false;
        try {

         if( wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) ).isDisplayed());
            dis=true;
            System.out.println("dis = " + dis);
          return dis ;
        }
        catch (Exception e){

            System.out.println("e = " + e);
            dis=false;
            System.out.println("dis catch = " + dis);

            return dis;
        }


    }

    public void enter ( By selector ){
        new WebDriverWait( driver , 20 ).until( ExpectedConditions.elementToBeClickable( selector ) ).click();
        find( selector ).sendKeys( Keys.ENTER );
    }


    public void clicRigthandMove ( By locator , By locatorMove ){

        WebElement b = find( locator );
        Actions action = new Actions( driver );
        action.contextClick( b ).build().perform();
        WebElement move = find( locatorMove );
        action.moveToElement( move );
        move.click();
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

    public void selectOption ( By locator , String value ){

        Select lista = new Select( find( locator ) );
        lista.selectByValue( value );

    }

    public void selectOptionByText ( By locator , String value ){

        Select lista = new Select( find( locator ) );
        lista.selectByVisibleText( value );

    }



}