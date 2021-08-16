package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectManagerPage extends BasePage {

    InicioPage inicio = new InicioPage();
    private static WebDriverWait wait;
    By project =By.cssSelector(  "#projectmanager_sidebox_header" );
    By add=By.id( "projectmanager-list_add" );
    By menu = By.cssSelector( "#calendar-et2_target > div:nth-child(1)" );
    By title=By.id( "projectmanager-edit_pm_title" );
    By messageSave=By.id("egw_message");
    By busqueda=By.cssSelector("#projectmanager-list_nm .et2_textbox");
    By cerrarProyecto=By.cssSelector( "#projectmanager-egw_fw_ui_tab_header > .egw_fw_ui_tab_close_button" );
    By resultado=By.cssSelector( ".rowNoUndelete [class*='_td_col_0']" );

    public ProjectManagerPage (){
        super( driver );
    }


    public String abrirVentanaProyecto (){

        scroll( project );
        click( add );
        String ventana= winHandles( 1 );
        switchToVentana(ventana);
        String titulo=getTitulo();
        System.out.println( "titulo = " + titulo );
        return titulo;

        }

        public void cerrarVentanaProyecto(){

        click( cerrarProyecto );
        }

     public boolean verificarMensaje(){

        return elementIsDisplayed(messageSave);

    }

    public void escribirProyectoCreado(String idByAddProyecto){
        String ventana= winHandles( 0 );
        switchToVentana(ventana);
         click( busqueda );
        write(busqueda,idByAddProyecto);
        enter( busqueda );
       String e= getText( resultado );
        System.out.println( "e = " + e );


    }



}
