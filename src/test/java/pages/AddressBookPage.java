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
    By cerrarPais=By.cssSelector( localizador.getProperty("cerrarCountryByCss" ));
    By paisContacto=By.cssSelector( localizador.getProperty("countryByCss" ));

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


    public String generarPrefix (){

       int prefixn = (int) (Math.random() * 1000 + 1);
       String prefix = "prefix"+ prefixn;
       return prefix;

   }
   public void agregarNombre(String nombre,String prefixs){
       click( name );
       write( prefix , prefixs );
       write( firstName , nombre );
       click( okBoton );

   }

    public void agregarOrganizacion(String organizations){
        write( organization , organizations );

    }

    public void agregarmMails(String mails){
        write( mail , mails );

    }

    public void agregarMovil(String movils){
        write( movil , movils );

    }
    public void agregarTelefNegocio(String bussPhones){
        write( bussPhone , bussPhones );

    }
    public void agregarOcupacion(String job){
        write( jobTitle , job );

    }

    public void guardarContacto(){
        click( applyBoton );
    }
public void agregarPais(String paisNuevo){


       click(cerrarPais );
       write(paisContacto,paisNuevo);


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
