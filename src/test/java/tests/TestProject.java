package tests;

import com.project.pom.AddProjectPage;
import com.project.pom.InicioPage;
import com.project.pom.ProjectManagerPage;
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

    @BeforeAll
    public void entrar (){

        login.IniciarSesion();
    }

    @Test
    public void testVerificarVentanaProyecto(){

        String tituloPagina= projectManager.abrirVentanaProyecto();
        assertEquals( "EGroupware [Project Manager - Add project]" ,tituloPagina );
        String id=addProjectPage.generarIdProyecto();
        addProjectPage.escribirProyecto(id);
        addProjectPage.guardarCambios();
        String mensajeSave=projectManager.getMensaje();
        assertEquals( "Project saved.",mensajeSave );
        projectManager.busquedaProyectoCreado( id );
        List<String> proyecto=new ArrayList<String>(  );
        proyecto=projectManager.getDatosProyecto();
        assertEquals(id,proyecto.get( 0 )  );
        assertEquals( "Proyecto de prueba",proyecto.get( 1 ) );
        //projectManager.eliminarProyecto( id );


    }






}
