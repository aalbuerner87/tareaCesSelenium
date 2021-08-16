package com.project.pom;

import org.openqa.selenium.By;

public class ResourcesPage extends BasePage {

    By resources = By.cssSelector( "#resources_sidebox_header" );
    By add=By.id( "resources-show_add" );

    public ResourcesPage ( ){
        super( driver );
    }

    public String abrirResources (){

       // scroll( resources );
        click( add );
        String ventana= winHandles( 1 );
        switchToVentana(ventana);
        String titulo=getTitulo();
        System.out.println( "titulo = " + titulo );
        return titulo;

    }




}
