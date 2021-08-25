package tests;

import org.junit.jupiter.api.*;
import pages.AddressBookPage;
import pages.InicioPage;
import util.DatosContactoproperties;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAddressBook {

    InicioPage login = new InicioPage();
    AddressBookPage addressBookPage = new AddressBookPage();
    DatosContactoproperties contacto = new DatosContactoproperties();
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

        nombre = contacto.getNombre();
        movil = contacto.getMovil();
        mail = contacto.getMail();
        prefix = addressBookPage.generarPrefix();
        bussPhones = contacto.getBussPhones();
        job = contacto.getJob();
        organizations = contacto.getOrganizations();
        pais = contacto.getPais();
    }

    @BeforeEach
    public void entrar (){

        login.IniciarSesion();

    }

    @Test
    @Tag("Para_Suite_AmbienteTest")
    @DisplayName("Test Crear Contacto Nuevo")
    public void testCrearContacto (){
        String tituloPagina = addressBookPage.getNombreVentanaAgenda();
        assertEquals( "EGroupware [Address Book]" , tituloPagina );
        addressBookPage.agregarOrganizacion( organizations );
        addressBookPage.agregarNombre( nombre , prefix );
        addressBookPage.agregarMovil( movil );
        addressBookPage.agregarTelefNegocio( bussPhones );
        addressBookPage.agregarmMails( mail );
        addressBookPage.agregarPais( pais );
        addressBookPage.agregarOcupacion( job );
        addressBookPage.guardarAgenda();
        String mensajesave = addressBookPage.getMensaje();
        assertEquals( "Contact saved" , mensajesave );
        addressBookPage.busquedaContactoCreado( mail );
        List<String> contacto = new ArrayList<String>();
        contacto = addressBookPage.getDatosContacto();
        String union = ", " + nombre + "\n" + organizations + "\n" + job;
        String telefonos = bussPhones + "\n" + movil;
        assertEquals( union , contacto.get( 0 ) );
        assertEquals( pais , contacto.get( 1 ) );
        assertEquals( telefonos , contacto.get( 2 ) );
        assertEquals( mail , contacto.get( 3 ) );
        addressBookPage.eliminarContacto();
        addressBookPage.confirmarDelete();
        String mensajedelete = addressBookPage.getMensaje();
        assertEquals( "1 event(s) Deleted" , mensajedelete );
        addressBookPage.cerrarVentanaAgenda();

    }


}
