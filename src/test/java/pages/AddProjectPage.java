package pages;

import org.openqa.selenium.By;
import util.LocalizadorAddProyProperties;

public class AddProjectPage extends BasePage {

    LocalizadorAddProyProperties locator=new LocalizadorAddProyProperties();
    By titulo = locator.getTitulo();
    By num = locator.getNum();
    By save = locator.getSave();
    By category = locator.getCategory();
    By members = locator.getMembers();
    By membersSelect = locator.getMembersSelect();
    By addMemBoton = locator.getAddMemBoton();
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
        enter( category );
        click( members );
        click( membersSelect );
        selectOptionByText( membersSelect , Miembro );
        enter( membersSelect );
        click( addMemBoton );

    }


}
