package pages;

import org.openqa.selenium.By;
import util.LeerProperties;

import java.util.Properties;

public class InicioPage extends BasePage {

    By login = By.xpath( "//input[@name='login']" );
    By clave = By.xpath( "//input[@name='passwd']" );
    By boton = By.cssSelector( "tr:nth-child(8) input" );
    String url ;
    String user  ;
    String pass  ;

    public InicioPage (){

        super( driver );
    }


    public void IniciarSesion (){

        LeerProperties datos= new LeerProperties();
        Properties credenciales=datos.leerDatos();
        user=credenciales.getProperty( "user" );
        pass=credenciales.getProperty( "pass" );
        url=credenciales.getProperty( "url" );
        navigateTo( url );
        write( login , user );
        write( clave , pass );
        click( boton );


    }


    }



