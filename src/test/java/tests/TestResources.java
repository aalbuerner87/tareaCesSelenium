package tests;
import com.project.pom.AddressBookPage;
import com.project.pom.InicioPage;
import com.project.pom.ResourcesPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestResources {

    InicioPage login=new InicioPage();
    ResourcesPage resourcesPage=new ResourcesPage();

    @BeforeAll
    public void entrar (){

        login.IniciarSesion();
    }

    @Test
    public void test(){

        resourcesPage.abrirResources();

    }
}
