package tests;

import com.project.pom.AddressBookPage;
import com.project.pom.InicioPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAddressBook {

    InicioPage login=new InicioPage();
    AddressBookPage addressBookPage=new AddressBookPage();

    @BeforeAll
    public void entrar (){

        login.IniciarSesion();
    }

    @Test
    public void test(){
     addressBookPage.abrirAgenda();
     addressBookPage.crearContacto();


    }





}
