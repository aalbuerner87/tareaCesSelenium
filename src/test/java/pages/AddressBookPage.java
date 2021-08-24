package pages;

import org.openqa.selenium.By;
import util.LeerProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AddressBookPage extends BasePage {

    LeerProperties localizadores = new LeerProperties();
    Properties localizador = localizadores.leerLocalizadores();
    By agenda = By.cssSelector( localizador.getProperty( "agendaByCss" ) );
    By add = By.id( localizador.getProperty( "addAgById" ) );
    By cerrarAgenda = By.cssSelector( localizador.getProperty( "cerrarAgendaByCss" ) );
    By organization = By.id( localizador.getProperty( "organizationById" ) );
    By name = By.cssSelector( localizador.getProperty( "nameByCss" ) );
    By prefix = By.cssSelector( localizador.getProperty( "prefixByCss" ) );
    By firstName = By.cssSelector( localizador.getProperty( "firstNameByCss" ) );
    By okBoton = By.id( localizador.getProperty( "okBotonById" ) );
    By saveBoton = By.id( localizador.getProperty( "saveBotonById" ) );
    By bussPhone = By.id( localizador.getProperty( "bussPhoneById" ) );
    By movil = By.id( localizador.getProperty( "movilById" ) );
    By mail = By.id( localizador.getProperty( "mailById" ) );
    By jobTitle = By.id( localizador.getProperty( "jobTitleById" ) );
    By busqueda = By.cssSelector( localizador.getProperty( "busquedaAdByCss" ) );


    By applyBoton = By.id( localizador.getProperty( "applyBotonById" ) );
    By nombreTabla = By.cssSelector( localizador.getProperty( "nombreTablaByCss" ) );
    By paisTabla = By.cssSelector( localizador.getProperty( "paisTablaByCss" ) );
    By celularTabla = By.cssSelector( localizador.getProperty( "celularTablaByCss" ) );
    By correoTabla = By.cssSelector( localizador.getProperty( "correoTablaByCss" ) );
    By delete = By.xpath( localizador.getProperty( "deleteByXp" ) );
    By area = By.cssSelector( localizador.getProperty( "areaByCss" ) );
    By yesBoton = By.id( localizador.getProperty( "yesBotonById" ) );

    public AddressBookPage (){
        super( driver );
    }


    public void abrirVentanaAgenda (){

        clickJs( agenda );
        click( add );
        String ventana = winHandles( 1 );
        switchToVentana( ventana );
    }

    public String getNombreVentanaAgenda (){
        abrirVentanaAgenda();
        String titulo = getTitle();
        return titulo;
    }


    public void crearContacto ( String organizations , String nombre , String mails , String prefixs , String movils , String bussPhones , String job ){

        write( organization , organizations );
        click( name );
        write( prefix , prefixs );
        write( firstName , nombre );
        click( okBoton );
        write( bussPhone , bussPhones );
        write( movil , movils );
        write( mail , mails );
        write( jobTitle , job );
        click( applyBoton );

    }

    public void guardarAgenda (){

        click( saveBoton );
    }

    public String getMensaje (){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        return messageGetText();
    }


    public void cerrarVentanaAgenda (){

        click( cerrarAgenda );
    }

    public void busquedaContactoCreado ( String mail ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        click( busqueda );
        write( busqueda , mail );
        enter( busqueda );

    }

    public List<String> getDatosContacto (){

        List<String> datosContacto = new ArrayList<String>();
        String nameT = getText( nombreTabla );
        String paisT = getText( paisTabla );
        String celularT = getText( celularTabla );
        String correoT = getText( correoTabla );
        datosContacto.add( nameT );
        datosContacto.add( paisT );
        datosContacto.add( celularT );
        datosContacto.add( correoT );
        return datosContacto;


    }


    public void eliminarContacto (){

        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        clicRigthandMove( area , delete );


    }

    public void confirmarDelete (){

        click( yesBoton );


    }


}
