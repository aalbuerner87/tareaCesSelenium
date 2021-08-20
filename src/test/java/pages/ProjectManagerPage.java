package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


public class ProjectManagerPage extends BasePage {

    InicioPage inicio = new InicioPage();
    private static WebDriverWait wait;
    By project = By.cssSelector( "#projectmanager_sidebox_header" );
    By add = By.id( "projectmanager-list_add" );
    By busqueda = By.cssSelector( "#projectmanager-list_nm .et2_textbox" );
    By cerrarProyecto = By.cssSelector( "#projectmanager-egw_fw_ui_tab_header > .egw_fw_ui_tab_close_button" );
    By idProyectoCreado = By.cssSelector( ".rowNoUndelete [class*='_td_col_0']" );
    By nombreProyectoCreado = By.cssSelector( ".rowNoUndelete [class*='_td_col_12']" );
    By priorityCreado=By.cssSelector( ".rowNoUndelete [class*='_td_col_1']" );
    By ownerCreado=By.cssSelector( ".rowNoUndelete [class*='_td_col_2']" );
    By startDateCreado=By.cssSelector( ".rowNoUndelete [class*='_td_col_4']" );
    By endDateCreado=By.cssSelector( ".rowNoUndelete [class*='_td_col_5']" );
    By budgCreado=By.cssSelector( ".rowNoUndelete [class*='_td_col_7']" );
    By timesCreado=By.cssSelector( ".rowNoUndelete [class*='_td_col_9']" );
    By delete = By.xpath( "//*[@class='sub_item'][contains(@id,'delete')]" );
    By open= By.xpath( "//*[@class='sub_item'][contains(@id,'open')]" );
    By texto = By.cssSelector( ".ui-dialog.ui-widget .ui-dialog-content" );
    By yesBoton=By.id("dialog[yes]");
    By noElementosBusqueda=By.xpath( "//*[@id=\"projectmanager-list_nm\"]/div[2]/table/tbody/tr/td/div/table/tbody/tr/td" );
    By titleTabla=By.cssSelector( ".th.rowNoDelete.row_category.row.ui-droppable [class*='_td_col_4']" );

    public ProjectManagerPage (){
        super( driver );
    }


    public void abrirVentanaProyecto (){

        clickJs( project );
        click( add );
        String ventana = winHandles( 1 );
        switchToVentana( ventana );
    }

    public void abrirTabProyecto (){

        clickJs( project );

    }

    public String getNombreVentanaProyecto(){
        abrirVentanaProyecto();
        String titulo = getTitle();
        return titulo;
    }

    public String getNombreVentanaEditarProyecto(){
        String ventana = winHandles( 1 );
        switchToVentana( ventana );
        String titulo = getTitle();
        return titulo;
    }

    public String getTextoVentanaConfirmacion(){

       return getText( texto );

    }

    public void confirmarDelete(){

        click( yesBoton );


    }

    public void cerrarVentanaProyecto (){

        click( cerrarProyecto );
    }

    public String getMensaje (){

        return messageGetText();
    }

    public void busquedaProyectoCreado ( String idByAddProyecto ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        click( busqueda );
        write( busqueda , idByAddProyecto );
        enter( busqueda );

    }

    public List<String> getDatosProyecto (){

        List<String> datosProyecto = new ArrayList<String>();

        datosProyecto.add( getText( idProyectoCreado ) );
        datosProyecto.add( getText( nombreProyectoCreado ) );
        datosProyecto.add( getText( priorityCreado ) );
        datosProyecto.add( getText( ownerCreado ) );
        datosProyecto.add( getText( startDateCreado ) );
        datosProyecto.add( getText(endDateCreado ) );
        datosProyecto.add( getText( budgCreado ) );
        datosProyecto.add( getText( timesCreado ) );


        return datosProyecto;


    }


    public void eliminarProyecto ( ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        clicRigthandMove( idProyectoCreado,delete );



    }

    public void abrirProyecto ( ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        clicRigthandMove( idProyectoCreado,open );



    }

    public boolean busquedaSinElementos(){

        return elementIsDisplayed( noElementosBusqueda );
    }

    public String comprobarRecursos(){

    dobleClick( nombreProyectoCreado );
    String miembro = getText( titleTabla );
    return miembro;

    }

    public void cerrarNavegador(){

        closedBrowser();

    }


}
