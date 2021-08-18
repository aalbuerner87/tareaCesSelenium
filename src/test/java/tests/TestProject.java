package tests;

import pages.AddProjectPage;
import pages.InicioPage;
import pages.ProjectManagerPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestProject {

    InicioPage login=new InicioPage();
    ProjectManagerPage projectManager=new ProjectManagerPage();
    AddProjectPage addProjectPage=new AddProjectPage();
    String id;
    String tituloProyecto;
    String tituloProyectoConsulta;

    @BeforeAll
    public void entrar (){

        login.IniciarSesion();
        tituloProyecto="Proyecto de prueba";
        tituloProyectoConsulta="Proyecto de prueba consulta";
    }

    @Test
    public void testVerificarVentanaProyecto (){

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
        boolean sinProyectos=projectManager.busquedaSinElementos();
        assertTrue(sinProyectos );
        projectManager.cerrarVentanaProyecto();


    }

    @Test

    public void consultarProyecto(){

        projectManager.abrirVentanaProyecto();
        id=addProjectPage.generarIdProyecto();
        addProjectPage.escribirProyecto(id,tituloProyectoConsulta);
        addProjectPage.guardarCambios();
        projectManager.busquedaProyectoCreado( id );
        projectManager.eliminarProyecto();

    }



}
