package cesAutomation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import util.LeeFichero;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CesAutomation {

    private WebDriver driver;
    By link = By.cssSelector( ".g:nth-child(1) > div:nth-child(2) .LC20lb" );
    By linkAcceder = By.linkText( "Acceder" );
    By nombre = By.id( "username" );
    By password = By.id( "password" );
    By entrar = By.id( "loginbtn" );
    By paginaCursos = By.linkText( "INTRODUCCION A LA AUTOMATIZACION DEL TESTING FUNCIONAL 202103" );
    By foro = By.cssSelector( "#module-21581 .instancename" );
    By linkBienvenida = By.linkText( "Bienvenida" );


    @BeforeAll
    public  void setUp (){
        System.setProperty( "webdriver.chrome.driver" , "./src/test/resources/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void cesBusqueda (){
        LeeFichero credencial= new LeeFichero();
        ArrayList<String> credenciales=credencial.leerFichero();
        String  user=credenciales.get( 0 );
        String  contra=credenciales.get(1);
        driver.get( "https://capacitacion.ces.com.uy" );
        driver.manage().timeouts().implicitlyWait( 5 , TimeUnit.SECONDS );
        driver.findElement( linkAcceder ).click();
        WebElement username = driver.findElement( nombre );
        username.clear();
        username.sendKeys(user);
        WebElement clave = driver.findElement( password );
        clave.clear();
        clave.sendKeys(contra );
        WebElement acceder = driver.findElement( entrar );
        acceder.submit();
        WebElement pagCursos = driver.findElement( paginaCursos );
        pagCursos.click();
        WebElement novedades = driver.findElement( foro );
        novedades.click();
        assertEquals( "Novedades" , driver.getTitle() );
        WebElement bienvenida = driver.findElement( linkBienvenida );
        assertEquals( "Bienvenida" , bienvenida.getText() );
    }

    @AfterAll
    public  void tearDown(){

        driver.quit();

    }




}
