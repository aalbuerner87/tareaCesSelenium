package tests;

import org.junit.jupiter.api.*;
import pages.AddProjectPage;
import pages.InicioPage;
import pages.ProjectManagerPage;
import util.LeerProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestProject {

    InicioPage login = new InicioPage();
    ProjectManagerPage projectManager = new ProjectManagerPage();
    AddProjectPage addProjectPage = new AddProjectPage();
    String id;
    String tituloProyecto;
    String tituloProyectoConsulta;
    String recursoAgregado;
    String idProyectoConsulta;
    String nombreProyectoConsulta;
    String priority;
    String owner;
    String startDate;
    String endDateCreado;
    String budg;
    String times;
    LeerProperties datos= new LeerProperties();
    Properties datosProyecto;

    @BeforeAll
    public void datos (){
        
        datosProyecto=datos.leerProperties();
        tituloProyecto = datosProyecto.getProperty("tituloProyecto");
        recursoAgregado = datosProyecto.getProperty( "recursoAgregado" );
        idProyectoConsulta =datosProyecto.getProperty( "recursoAgregado" );
        nombreProyectoConsulta =datosProyecto.getProperty( "nombreProyectoConsulta" );
        priority =datosProyecto.getProperty( "priority" );
        owner =datosProyecto.getProperty( "owner" );
        startDate =datosProyecto.getProperty( "startDate" );
        endDateCreado=datosProyecto.getProperty( "endDateCreado" );
        budg=datosProyecto.getProperty( "budg" );
        times =datosProyecto.getProperty( "times" );

    }

    @BeforeEach
    public void entrar (){

        login.IniciarSesion();

    }

    @Test
    public void testCrearProyecto (){

        String tituloPagina = projectManager.getNombreVentanaProyecto();
        assertEquals( "EGroupware [Project Manager - Add project]" , tituloPagina );
        id = addProjectPage.generarIdProyecto();
        addProjectPage.escribirProyecto( id , tituloProyecto );
        addProjectPage.guardarCambios();
        String mensajeSave = projectManager.getMensaje();
        assertEquals( "Project saved." , mensajeSave );
        projectManager.busquedaProyectoCreado( id );
        List<String> proyecto = new ArrayList<String>();
        proyecto = projectManager.getDatosProyecto();
        assertEquals( id , proyecto.get( 0 ) );
        assertEquals( tituloProyecto , proyecto.get( 1 ) );
        projectManager.eliminarProyecto();
        String texto = projectManager.getTextoVentanaConfirmacion();
        assertEquals( "Delete this project?" , texto );
        projectManager.confirmarDelete();
        String mensajedelete = projectManager.getMensaje();
        assertEquals( "1 project(s) Deleted" , mensajedelete );
        projectManager.busquedaProyectoCreado( id );
        boolean sinProyectos = projectManager.busquedaSinElementos();
        assertTrue( sinProyectos );
        projectManager.cerrarVentanaProyecto();


    }

    @Test

    public void testConsultarProyecto (){

        projectManager.abrirTabProyecto();
        id = datosProyecto.getProperty( "idProyectoConsulta" );
        projectManager.busquedaProyectoCreado( id );
        List<String> proyecto = new ArrayList<String>();
        proyecto = projectManager.getDatosProyecto();
        assertEquals( id , proyecto.get( 0 ) );
        assertEquals( nombreProyectoConsulta , proyecto.get( 1 ) );
        assertEquals( priority , proyecto.get( 2 ) );
        assertEquals( owner , proyecto.get( 3 ) );
        assertEquals( startDate , proyecto.get( 4 ) );
        assertEquals( endDateCreado , proyecto.get( 5 ) );
        assertEquals( budg , proyecto.get( 6 ) );
        assertEquals( times , proyecto.get( 7 ) );
        projectManager.cerrarVentanaProyecto();
    }


    @Test
    public void testAgregarRecursoMiembro (){
        projectManager.abrirVentanaProyecto();
        id = addProjectPage.generarIdProyecto();
        addProjectPage.escribirProyecto( id , tituloProyecto );
        addProjectPage.guardarCambios();
        projectManager.busquedaProyectoCreado( id );
        projectManager.abrirProyecto();
        addProjectPage.agregarRecursoMiembro( recursoAgregado );
        addProjectPage.guardarCambios();
        String recursoAgregadoM = projectManager.comprobarRecursos();
        assertEquals( recursoAgregado , recursoAgregadoM );
        projectManager.cerrarVentanaProyecto();
        projectManager.abrirTabProyecto();
        projectManager.eliminarProyecto();
        projectManager.confirmarDelete();
        String mensajedelete = projectManager.getMensaje();
        assertEquals( "1 project(s) Deleted" , mensajedelete );
        projectManager.cerrarVentanaProyecto();


    }

    @AfterAll
    public void cerrarNavegador (){

        projectManager.cerrarNavegador();

    }

}