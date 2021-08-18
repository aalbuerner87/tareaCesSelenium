package pages;

import org.openqa.selenium.By;

public class AddProjectPage extends BasePage {


    By titulo = By.id( "projectmanager-edit_pm_title" );
    By num = By.id( "projectmanager-edit_pm_number" );
    By save = By.id( "projectmanager-edit_save" );
    By messageSave = By.id( "egw_message" );
    String id = "";
    By category = By.id( "projectmanager-edit_cat_id" );
    By optionCategory = By.xpath( "//*[@id=\"projectmanager-edit_cat_id\"]/option[2]" );
    By members = By.xpath( "//*[@id=\"projectmanager-edit_tabs\"]/div[1]/span[3]" );
    By membersSelect = By.id( "projectmanager-edit_member[1]" );
    By memOtion = By.xpath( "//*[@id=\"projectmanager-edit_member[1]\"]/option[3]" );
    By addMemBoton = By.cssSelector( "#projectmanager-edit_add" );


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


    public void agregarRecursoMiembro (String Miembro){


        String ventana = winHandles( 1 );
        switchToVentana( ventana );
        click( category );
        String video="29";
        selectOption( category,video );;
        enter( category );
        click( members );
        click( membersSelect );
        selectOptionByText(membersSelect,Miembro );
        enter( membersSelect );
        click(addMemBoton);

    }


}
