package com.project.pom;

import org.openqa.selenium.By;

public class AddressBookPage extends BasePage {

    By agenda = By.cssSelector( "#addressbook_sidebox_header" );
    By add=By.id( "addressbook-index_add" );
    By cerrarAgenda=By.id("tengo que buscarlo");
    By organization=By.id( "addressbook-edit_org_name" );

    public AddressBookPage ( ){
        super( driver );
    }

    public String abrirAgenda (){

       // scroll( agenda );
        click( add );
        String ventana= winHandles( 1 );
        switchToVentana(ventana);
        String titulo=getTitulo();
        System.out.println( "titulo = " + titulo );
        return titulo;

    }

    public void crearContacto(){

        write( organization,"CES organizacion de prueba" );

    }

    public void cerrarVentanaProyecto(){

        click( cerrarAgenda);
    }



}
