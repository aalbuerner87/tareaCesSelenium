package com.project.pom;

import org.openqa.selenium.By;
public class AddressBookPage extends BasePage {

    By agenda = By.cssSelector( "#addressbook_sidebox_header" );
    By add=By.id( "addressbook-index_add" );
    By cerrarAgenda=By.id("tengo que buscarlo");
    By organization=By.id( "addressbook-edit_org_name" );
    By name=By.cssSelector( "#addressbook-edit_n_fn" );
    By prefix=By.cssSelector( "#addressbook-edit_n_prefix" );
    By firstName=By.cssSelector( "#addressbook-edit_n_given" );
    By okBoton=By.id( "addressbook-edit_button[ok]" );
    By saveBoton=By.id( "addressbook-edit_button[save]" );
    By bussPhone=By.id( "addressbook-edit_tel_work" );
    By movil=By.id( "addressbook-edit_tel_cell" );
    By mail=By.id("addressbook-edit_email");
    By jobTitle=By.id( "addressbook-edit_title" );
    By busqueda=By.cssSelector( "##addressbook-index_nm .et2_textbox" );
    By applyBoton=By.id("addressbook-edit_button[apply]");

    public AddressBookPage ( ){
        super( driver );
    }


        public void abrirVentanaAgenda (){

            clickJs( agenda );
            click( add );
            String ventana = winHandles( 1 );
            switchToVentana( ventana );
        }

        public String getNombreVentanaAgenda(){
            abrirVentanaAgenda();
            String titulo = getTitulo();
            return titulo;
        }


    public void crearContacto(String nombre,String mails,String prefixs,String movils){

        write( organization,"CES organizacion de prueba" );
        click( name );
        write( prefix,prefixs );
        write(firstName,nombre);
        click(okBoton);
        write(bussPhone,"091961938");
        write(movil,movils);
        write(mail,mails);
        write( jobTitle,"ingeniero" );
        click( applyBoton );

    }

    public void guardarAgenda(){

        click(saveBoton);
    }

    public String getMensaje (){
        System.out.println( " messageGetText() = " +  messageGetText() );
        return messageGetText();
    }

    public void cerrarVentanaProyecto(){

        click( cerrarAgenda);
    }

    public void busquedaContactoCreado ( String nombre ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        click( busqueda );
        write( busqueda , nombre );
        enter( busqueda );

    }


}
