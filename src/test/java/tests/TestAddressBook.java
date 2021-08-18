package tests;

import pages.AddressBookPage;
import pages.InicioPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAddressBook {

    InicioPage login=new InicioPage();
    AddressBookPage addressBookPage=new AddressBookPage();

    @BeforeAll
    public void entrar (){

        login.IniciarSesion();
    }

    @Test
    public void test(){
     String tituloPagina= addressBookPage.getNombreVentanaAgenda();
     assertEquals( "EGroupware [Address Book]" ,tituloPagina );
     String nombre="Ariagna3";
     String movil="091961938";
     String mail="a@gmail.com";
     String prefix="prefix05";
     String bussPhones="091961938";
     String job="Ingeniero";
     String organizations="CES";
     addressBookPage.crearContacto(organizations,nombre,mail,prefix,movil,bussPhones,job);
     String mensajeSave=addressBookPage.getMensaje();
     assertEquals( "Contact saved",mensajeSave );
     addressBookPage.guardarAgenda();
     addressBookPage.busquedaContactoCreado( nombre );

     //addressBookPage.busquedaContactoCreado( "ariagna" );


    }





}
