package tests;

import org.junit.jupiter.api.*;
import pages.AddProjectPage;
import pages.InicioPage;
import pages.ProjectManagerPage;

import java.util.ArrayList;
import java.util.List;

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


    @BeforeAll
    public void datos (){
        // login.IniciarSesion();
        tituloProyecto = login.leerProperties().get( 11 ).replace( "tituloProyecto=" , "" );
        tituloProyectoConsulta = login.leerProperties().get( 12 ).replace( "tituloProyectoConsulta=" , "" );
        recursoAgregado = login.leerProperties().get( 13 ).replace( "recursoAgregado=" , "" );

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

        projectManager.abrirVentanaProyecto();
        id = addProjectPage.generarIdProyecto();
        addProjectPage.escribirProyecto( id , tituloProyectoConsulta );
        addProjectPage.guardarCambios();
        projectManager.busquedaProyectoCreado( id );
        List<String> proyecto = new ArrayList<String>();
        proyecto = projectManager.getDatosProyecto();
        assertEquals( id , proyecto.get( 0 ) );
        assertEquals( tituloProyectoConsulta , proyecto.get( 1 ) );
        projectManager.abrirProyecto();
        String tituloPagina = projectManager.getNombreVentanaEditarProyecto();
        assertEquals( "EGroupware [Project Manager - Edit project]" , tituloPagina );
        addProjectPage.guardarCambios();
        projectManager.eliminarProyecto();
        projectManager.confirmarDelete();
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
        projectManager.clickjs();
        projectManager.eliminarProyecto();
        projectManager.confirmarDelete();
        projectManager.cerrarVentanaProyecto();


    }

    @AfterAll
    public void cerrarNavegador (){

        projectManager.cerrarNavegador();

    }

}