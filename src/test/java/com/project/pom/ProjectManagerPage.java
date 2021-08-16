package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectManagerPage extends Base {

    InicioPage inicio = new InicioPage();
    private static WebDriverWait wait;
    By project = By.cssSelector( "#projectmanager_sidebox_header" );
    By add=By.id( "projectmanager-list_add" );
    By menu = By.cssSelector( "#calendar-et2_target > div:nth-child(1)" );
    By title=By.id( "projectmanager-edit_pm_title" );
    By messageSave=By.id("ewg_message");
    By busqueda=By.className("et2_textbox");

    public ProjectManagerPage (){
        super( driver );
    }


    public String abrirVentanaProyecto (){

        scroll( project );
        scroll( project );
        scroll( project );
        click( project );
        click( add );
        String ventana=VentanasHandles( 1 );
        switchToVentana(ventana);
        String titulo=getTitulo();
        System.out.println( "titulo = " + titulo );
        return titulo;

        }


    public boolean verificarMensaje(){

        return elementIsDisplayed(messageSave);

    }

    public void escribirProyectoCreado(String idByAddProyecto){


        write(busqueda,idByAddProyecto);


    }



}
