package com.project.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class AddProjectPage extends Base{


    By titulo=By.id( "projectmanager-edit_pm_title" );
    By num=By.id("projectmanager-edit_pm_number");
    By save=By.id("projectmanager-edit_save");
    By messageSave=By.id("ewg_message");
    String id="";

    public AddProjectPage ( ){
        super( driver );
    }


    public void escribirProyecto(String idGenerado){

    write( titulo,"Proyecto de prueba");
    write(num,idGenerado);

    }

    public String generarIdProyecto(){

        int numero = (int)(Math.random()*10000+1);
        id="id-proyecto"+"-"+numero;
        return id;

    }

    public void guardarCambios(){

    click( save );


    }

  public boolean verificarMensaje(){

   return elementIsDisplayed(messageSave);

    }




}
