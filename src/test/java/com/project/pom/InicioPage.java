package com.project.pom;

import org.openqa.selenium.By;

public class InicioPage extends BasePage {

    By login = By.xpath( "//input[@name='login']" );
    By clave = By.xpath( "//input[@name='passwd']" );
    By boton = By.cssSelector( "tr:nth-child(8) input" );
    String url = "http://egroupware.cursos.ces.com.uy/egroupware/login.php";
    String user = "aalbuerne";
    String pass = "aalbuerne";

    public InicioPage (){

        super( driver );
    }


    public void IniciarSesion (){

        driver.manage().window().maximize();
        navigateTo( url );
        write( login , user );
        write( clave , pass );
        click( boton );

    }




}
