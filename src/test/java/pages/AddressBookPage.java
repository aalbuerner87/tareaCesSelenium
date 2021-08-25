package pages;

import org.openqa.selenium.By;
import properties.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBookPage extends BasePage {

    LocalizadorAddressBookProperties locator = new LocalizadorAddressBookProperties();
    By agenda = locator.getAgenda();
    By add = locator.getAddAg();
    By cerrarAgenda = locator.getCerrarAgenda();
    By busqueda = locator.getBusqueda();
    By applyBoton = locator.getApplyBoton();
    By nombreTabla = locator.getNombreTabla();
    By paisTabla = locator.getPaisTabla();
    By celularTabla = locator.getCelularTabla();
    By correoTabla = locator.getCorreoTabla();
    By delete = locator.getDelete();
    By area = locator.getArea();
    By yesBoton = locator.getYesBoton();

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
