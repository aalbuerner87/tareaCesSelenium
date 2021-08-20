package tests;

import org.junit.jupiter.api.*;
import pages.AddressBookPage;
import pages.InicioPage;
import util.LeerProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
    public void datos (){

        LeerProperties datos= new LeerProperties();
        Properties contacto=datos.leerProperties();
         nombre=contacto.getProperty( "nombre" );
         movil=contacto.getProperty( "movil" );
         mail=contacto.getProperty( "mail" );
         prefix=contacto.getProperty( "prefix" );
         bussPhones=contacto.getProperty( "bussPhones" );
         job=contacto.getProperty( "job" );
         organizations=contacto.getProperty( "organizations" );
         pais=contacto.getProperty( "pais" );
    }

    @BeforeEach
    public void entrar (){

        login.IniciarSesion();

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
        addressBookPage.confirmarDelete();
       addressBookPage.cerrarVentanaAgenda();

    }

    @AfterAll
    public void cerrarNavegador(){

        addressBookPage.cerrarNavegador();
    }



}
