package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LeerProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ProjectManagerPage extends BasePage {

    LeerProperties localizadores = new LeerProperties();
    Properties localizador = localizadores.leerLocalizadores();
    By project = By.cssSelector( localizador.getProperty( "projectById" ) );
    By add = By.id( localizador.getProperty( "addById" ) );
    By busqueda = By.cssSelector( localizador.getProperty( "busquedaByCss" ) );
    By cerrarProyecto = By.cssSelector( localizador.getProperty( "cerrarProyectoByCss" ) );
    By idProyectoCreado = By.cssSelector( localizador.getProperty( "idProyectoCreadoByCss" ) );
    By nombreProyectoCreado = By.cssSelector( localizador.getProperty( "nombreProyectoCreadoByCss" ) );
    By priorityCreado = By.cssSelector( localizador.getProperty( "priorityCreadoByCss" ) );
    By startDateCreado = By.cssSelector( localizador.getProperty( "startDateCreadoByCss" ) );
    By endDateCreado = By.cssSelector( localizador.getProperty( "endDateCreadoByCss" ) );
    By budgCreado = By.cssSelector( localizador.getProperty( "budgCreadoByCss" ) );
    By timesCreado = By.cssSelector( localizador.getProperty( "timesCreadoByCss" ) );
    By delete = By.xpath( localizador.getProperty( "deleteProjectByXp" ) );
    By open = By.xpath( localizador.getProperty( "openByXp" ) );
    By texto = By.cssSelector( localizador.getProperty( "textoByCss" ) );
    By yesBoton = By.id( localizador.getProperty( "yesBotonById" ) );
    By noElementosBusqueda = By.xpath( localizador.getProperty( "noElementosBusquedaByXp" ) );
    By titleTabla = By.cssSelector( localizador.getProperty( "titleTablaByCss" ) );

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

    public String getNombreVentanaProyecto (){
        abrirVentanaProyecto();
        String titulo = getTitle();
        return titulo;
    }


    public String getTextoVentanaConfirmacion (){

        return getText( texto );

    }

    public void confirmarDelete (){

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
        datosProyecto.add( getText( startDateCreado ) );
        datosProyecto.add( getText( endDateCreado ) );
        datosProyecto.add( getText( budgCreado ) );
        datosProyecto.add( getText( timesCreado ) );


        return datosProyecto;


    }

    public boolean idBusquedaDevuelto ( String idProyectoExistente ){
        boolean compara = getText( idProyectoCreado ).equals( idProyectoExistente );
        return compara;

    }

    public boolean nombreProyectoDevuelto ( String nombreExistente ){
        boolean compara = getText( nombreProyectoCreado ).equals( nombreExistente );
        return compara;

    }

    public boolean priorityDevuelto ( String priorityExistente ){
        boolean compara = getText( priorityCreado ).equals( priorityExistente );
        return compara;
    }

    public boolean startDateDevuelto ( String startDateExistente ){

        boolean compara = getText( startDateCreado ).equals( startDateExistente );
        return compara;

    }

    public boolean endDateDevuelto ( String endDateExistente ){

        boolean compara = getText( endDateCreado ).equals( endDateExistente );
        return compara;
    }

    public boolean budgDevuelto ( String budgExistente ){

        boolean compara = getText( budgCreado ).equals( budgExistente );
        return compara;

    }

    public boolean timesDevuelto ( String timesExistente ){
        boolean compara = getText( timesCreado ).equals( timesExistente );
        return compara;

    }

    public void eliminarProyecto (){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        clicRigthandMove( idProyectoCreado , delete );


    }

    public void abrirProyecto (){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        clicRigthandMove( idProyectoCreado , open );


    }

    public boolean busquedaSinElementos (){

        return elementIsDisplayed( noElementosBusqueda );
    }

    public String comprobarRecursos (){

        dobleClick( nombreProyectoCreado );
        String miembro = getText( titleTabla );
        return miembro;

    }

    public void cerrarNavegador (){

        closedBrowser();

    }


}
