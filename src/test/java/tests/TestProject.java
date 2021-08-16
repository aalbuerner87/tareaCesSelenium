package tests;

import com.project.pom.AddProjectPage;
import com.project.pom.InicioPage;
import com.project.pom.ProjectManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestProject {

    InicioPage login=new InicioPage();
    ProjectManager projectManager=new ProjectManager();
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
       /* boolean mensajeSave=projectManager.verificarMensaje();
        assertTrue( mensajeSave );*/
       projectManager.escribirProyectoCreado(id );


    }




}
