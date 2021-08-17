package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class ProjectManagerPage extends BasePage {

    InicioPage inicio = new InicioPage();
    private static WebDriverWait wait;
    By project = By.cssSelector( "#projectmanager_sidebox_header" );
    By add = By.id( "projectmanager-list_add" );
    By menu = By.cssSelector( "#calendar-et2_target > div:nth-child(1)" );
    By title = By.id( "projectmanager-edit_pm_title" );
    //By messageSave = By.id( "egw_message" );
    By busqueda = By.cssSelector( "#projectmanager-list_nm .et2_textbox" );
    By cerrarProyecto = By.cssSelector( "#projectmanager-egw_fw_ui_tab_header > .egw_fw_ui_tab_close_button" );
    By idProyectoCreado = By.cssSelector( ".rowNoUndelete [class*='_td_col_0']" );
    By nombreProyectoCreado = By.cssSelector( ".rowNoUndelete [class*='_td_col_12']" );
    By delete = By.cssSelector( "#MONyvUQ47VrFdelete > .sub_item_text .sub_item_text" );

    public ProjectManagerPage (){
        super( driver );
    }


    public String abrirVentanaProyecto (){

        clickJs( project );
        click( add );
        String ventana = winHandles( 1 );
        switchToVentana( ventana );
        String titulo = getTitulo();
        return titulo;

    }

    public void cerrarVentanaProyecto (){

        click( cerrarProyecto );
    }

    public String getMensaje (){

        return messageGetText();
    }

    public void busquedaProyectoCreado ( String idByAddProyecto ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        click( busqueda );
        write( busqueda , idByAddProyecto );
        enter( busqueda );

    }

    public List<String> getDatosProyecto (){

        List<String> datosProyecto = new ArrayList<String>( );
        String idProyecto = getText( idProyectoCreado );
        String nombreProyecto = getText( nombreProyectoCreado );
        datosProyecto.add( idProyecto );
        datosProyecto.add( nombreProyecto );
        System.out.println( "nombreProyecto = " + nombreProyecto );
        System.out.println( "e = " + idProyecto );
        return datosProyecto;


    }


    public void eliminarProyecto ( String idByAddProyecto ){

        clicRigth( idProyectoCreado );
        click( delete );


    }


}
