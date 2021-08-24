package pages;

import org.openqa.selenium.By;
import util.LeerProperties;

import java.util.Properties;

public class InicioPage extends BasePage {


    String url;
    String user;
    String pass;

    LeerProperties localizadores = new LeerProperties();
    Properties localizador = localizadores.leerLocalizadores();
    LeerProperties datos = new LeerProperties();
    Properties credenciales = datos.leerDatos();
    By login = By.xpath( localizador.getProperty( "loginByXp" ) );
    By clave = By.xpath( localizador.getProperty( "claveByXp" ) );
    By boton = By.xpath( localizador.getProperty( "botonByXp" ) );


    public InicioPage (){

        super( driver );
    }


    public void IniciarSesion (){


        user = credenciales.getProperty( "user" );
        pass = credenciales.getProperty( "pass" );
        url = credenciales.getProperty( "url" );
        navigateTo( url );
        write( login , user );
        write( clave , pass );
        click( boton );


    }


}



