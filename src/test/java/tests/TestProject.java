package tests;

import org.junit.jupiter.api.*;
import pages.AddProjectPage;
import pages.InicioPage;
import pages.ProjectManagerPage;
import properties.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestProject {

    InicioPage login = new InicioPage();
    ProjectManagerPage projectManager = new ProjectManagerPage();
    AddProjectPage addProjectPage = new AddProjectPage();
    DatosProyectoProperties datos =new DatosProyectoProperties();
    String id;
    String tituloProyecto;
    String recursoAgregado;
    String idProyectoConsulta;
    String nombreProyectoConsulta;
    String priority;
    String startDate;
    String endDateCreado;
    String budg;
    String times;



    @BeforeAll
    public void datos (){


        tituloProyecto = datos.getTituloProyecto();
        recursoAgregado = datos.getRecursoAgregado();
        idProyectoConsulta = datos.getIdProyectoConsulta();
        nombreProyectoConsulta = datos.getNombreProyectoConsulta();
        priority = datos.getPriority();
        startDate = datos.getStartDate();
        endDateCreado = datos.getEndDateCreado();
        budg = datos.getBudg();
        times=datos.getTimes();
    }

    @BeforeEach
    public void entrar () {

        login.IniciarSesion();

    }

    @Test
    @Tag("Para_Suite_AmbienteTest")
    @DisplayName("Test crear proyecto")
    @Order(1)
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
    @Tag("Para_Suite_AmbienteTest")
    @DisplayName("Test consulta de un proyecto creado")
    @Order(2)
    public void testConsultarProyecto (){

        projectManager.abrirTabProyecto();
        id=datos.getIdProyectoConsulta();
        projectManager.busquedaProyectoCreado( id );
        boolean comparaId = projectManager.idBusquedaDevuelto( id );
        boolean comparaNombre = projectManager.nombreProyectoDevuelto( nombreProyectoConsulta );
        boolean comparaPriority = projectManager.priorityDevuelto( priority );
        boolean comparaStartDate = projectManager.startDateDevuelto( startDate );
        boolean comparaEndDate = projectManager.endDateDevuelto( endDateCreado );
        boolean comparaBudg = projectManager.budgDevuelto( budg );
        boolean comparaTimes = projectManager.timesDevuelto( times );
        assertTrue( comparaId );
        assertTrue( comparaNombre );
        assertTrue( comparaPriority );
        assertTrue( comparaStartDate );
        assertTrue( comparaEndDate );
        assertTrue( comparaBudg );
        assertTrue( comparaTimes );
        projectManager.cerrarVentanaProyecto();
}


    @Test
    @Tag("Para_Suite_AmbienteTest")
    @DisplayName("Test agrega recursos a un proyecto")
    @Order(3)
    public void testAgregarRecursoMiembro (){
        projectManager.abrirTabProyecto();
        projectManager.abrirVentanaProyecto();
        id = addProjectPage.generarIdProyecto();
        addProjectPage.escribirProyecto( id , tituloProyecto );
        addProjectPage.guardarCambios();
        String mensajeSave = projectManager.getMensaje();
        assertEquals( "Project saved." , mensajeSave );
        projectManager.busquedaProyectoCreado( id );
        projectManager.abrirProyecto();
        addProjectPage.agregarRecursoMiembro( recursoAgregado );
        addProjectPage.guardarCambios();
        String mensajeSave2 = projectManager.getMensaje();
        assertEquals( "Project saved." , mensajeSave2 );
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