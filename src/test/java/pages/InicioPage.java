package pages;

import org.openqa.selenium.By;
import util.LeeFichero;

import java.util.ArrayList;
import java.util.List;

public class InicioPage extends BasePage {

    By login = By.xpath( "//input[@name='login']" );
    By clave = By.xpath( "//input[@name='passwd']" );
    By boton = By.cssSelector( "tr:nth-child(8) input" );
    String url = "http://egroupware.cursos.ces.com.uy/egroupware/login.php";
    String user  ;
    String pass  ;

    public InicioPage (){

        super( driver );
    }


    public void IniciarSesion (){

        driver.manage().window().maximize();
        navigateTo( url );
        List<String> credenciales=leerCredenciales();
        user=credenciales.get( 0 ).replace( "user=","" );
        pass=credenciales.get( 1 ).replace(  "pass=","" );
        write( login , user );
        write( clave , pass );
        click( boton );

    }

    public List<String> leerCredenciales (){
        LeeFichero credencial = new LeeFichero();
        List<String> credenciales = new ArrayList<String>();
        credenciales = credencial.leerFichero();
        return credenciales;


    }


}
