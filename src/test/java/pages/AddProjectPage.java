package pages;

import org.openqa.selenium.By;
import util.LeerProperties;

import java.util.Properties;

public class AddProjectPage extends BasePage {

    LeerProperties localizadores = new LeerProperties();
    Properties localizador = localizadores.leerLocalizadores();
    By titulo = By.id( localizador.getProperty( "tituloById" ) );
    By num = By.id( localizador.getProperty( "numById" ) );
    By save = By.id( localizador.getProperty( "saveById" ) );
    By category = By.id( localizador.getProperty( "categoryById" ) );
    By members = By.xpath( localizador.getProperty( "membersByXp" ) );
    By membersSelect = By.id( localizador.getProperty( "membersSelectById" ) );
    By addMemBoton = By.cssSelector( localizador.getProperty( "addMemBotonByCss" ) );
    String id = "";

    public AddProjectPage (){
        super( driver );
    }


    public void escribirProyecto ( String idGenerado , String tituloProyecto ){

        write( titulo , tituloProyecto );
        write( num , idGenerado );

    }

    public String generarIdProyecto (){

        int numero = (int) (Math.random() * 10000 + 1);
        id = "id-proyecto" + "-" + numero;
        return id;

    }

    public void guardarCambios (){

        click( save );
        String ventana = winHandles( 0 );
        switchToVentana( ventana );

    }


    public void agregarRecursoMiembro ( String Miembro ){


        String ventana = winHandles( 1 );
        switchToVentana( ventana );
        click( category );
        String video = "29";
        selectOption( category , video );
        ;
        enter( category );
        click( members );
        click( membersSelect );
        selectOptionByText( membersSelect , Miembro );
        enter( membersSelect );
        click( addMemBoton );

    }


}
