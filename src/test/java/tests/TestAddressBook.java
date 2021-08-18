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
         nombre=login.leerProperties().get( 3 ).replace( "nombre=","" );
         movil=login.leerProperties().get( 4 ).replace( "movil=","" );
         mail=login.leerProperties().get( 5 ).replace( "mail=","" );
         prefix=login.leerProperties().get( 6 ).replace( "prefix=","" );
         bussPhones=login.leerProperties().get( 7 ).replace( "bussPhones=","" );
         job=login.leerProperties().get( 8 ).replace( "job=","" );
         organizations=login.leerProperties().get( 9 ).replace( "organizations=","" );
         pais=login.leerProperties().get( 10 ).replace( "pais=","" );
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
