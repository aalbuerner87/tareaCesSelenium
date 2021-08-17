package com.project.pom;
import org.openqa.selenium.By;

public class AddProjectPage extends BasePage {


    By titulo=By.id( "projectmanager-edit_pm_title" );
    By num=By.id("projectmanager-edit_pm_number");
    By save=By.id("projectmanager-edit_save");
    By messageSave=By.id("egw_message");
    String id="";

    public AddProjectPage ( ){
        super( driver );
    }


    public void escribirProyecto(String idGenerado,String tituloProyecto){

    write( titulo,tituloProyecto);
    write(num,idGenerado);

    }

    public String generarIdProyecto(){

        int numero = (int)(Math.random()*10000+1);
        id="id-proyecto"+"-"+numero;
        return id;

    }

    public void guardarCambios(){

    click( save );
    String ventana= winHandles( 0 );
    switchToVentana(ventana);



    }



  public boolean verificarMensaje(){

      System.out.println( "elementIsDisplayed(messageSave) = " + elementIsDisplayed(messageSave) );

   return elementIsDisplayed(messageSave);

    }
    public String getMensaje (){

        return messageGetText();
    }




}
