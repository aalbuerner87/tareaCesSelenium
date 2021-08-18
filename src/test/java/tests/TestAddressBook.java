package tests;

import org.junit.jupiter.api.AfterAll;
import pages.AddressBookPage;
import pages.InicioPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAddressBook {

    InicioPage login=new InicioPage();
    AddressBookPage addressBookPage=new AddressBookPage();
    String nombre;
    String movil;
    String mail;
    String prefix;
    String bussPhones;
    String job;
    String organizations;
    String pais;

    @BeforeAll
    public void entrar (){

        login.IniciarSesion();
         nombre="Ariagna3";
         movil="091961938";
         mail="a@gmail.com";
         prefix="prefix05";
         bussPhones="091961938";
         job="Ingeniero";
         organizations="CES";
         pais="GERMANY";
    }

    @Test
    public void testCrearContacto (){
        String tituloPagina = addressBookPage.getNombreVentanaAgenda();
        assertEquals( "EGroupware [Address Book]" , tituloPagina );
        addressBookPage.crearContacto( organizations , nombre , mail , prefix , movil , bussPhones , job );
        addressBookPage.guardarAgenda();
        addressBookPage.busquedaContactoCreado( mail );
        List<String> contacto = new ArrayList<String>();
        contacto = addressBookPage.getDatosContacto();
        String union = ", " + nombre + "\n" + organizations + "\n" + job;
        String telefonos = movil + "\n" + bussPhones;
        assertEquals( union , contacto.get( 0 ) );
        assertEquals( pais , contacto.get( 1 ) );
        assertEquals( telefonos , contacto.get( 2 ) );
        assertEquals( mail , contacto.get( 3 ) );
        addressBookPage.eliminarContacto();





    }

    @AfterAll
    public void cerrarNavegador(){

        addressBookPage.cerrarNavegador();
    }



}
