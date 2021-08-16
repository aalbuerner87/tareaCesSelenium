package com.project.pom;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class InicioPage extends Base {

   By login=By.xpath("//input[@name='login']"  );
   By clave=By.xpath( "//input[@name='passwd']" );
   By boton = By.cssSelector( "tr:nth-child(8) input" );


    public InicioPage ( ){
        super( driver );
    }



    public void IniciarSesion(){
    driver.manage().window().maximize();
    navigateTo( "http://egroupware.cursos.ces.com.uy/egroupware/login.php" );
    write ( login , "aalbuerne");
    write(clave,"aalbuerne");
    click(boton);

}





}
