package pages;

import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class AddressBookPage extends BasePage {

    By agenda = By.cssSelector( "#addressbook_sidebox_header" );
    By add=By.id( "addressbook-index_add" );
    By cerrarAgenda=By.id("tengo que buscarlo");
    By organization=By.id( "addressbook-edit_org_name" );
    By name=By.cssSelector( "#addressbook-edit_n_fn" );
    By prefix=By.cssSelector( "#addressbook-edit_n_prefix" );
    By firstName=By.cssSelector( "#addressbook-edit_n_given" );
    By okBoton=By.id( "addressbook-edit_button[ok]" );
    By saveBoton=By.id( "addressbook-edit_button[save]" );
    By bussPhone=By.id( "addressbook-edit_tel_work" );
    By movil=By.id( "addressbook-edit_tel_cell" );
    By mail=By.id("addressbook-edit_email");
    By jobTitle=By.id( "addressbook-edit_title" );
    By busqueda=By.cssSelector( "#addressbook-index_nm .et2_textbox" );
    By applyBoton=By.id("addressbook-edit_button[apply]");
    By nombreTabla = By.cssSelector( ".contact_contact [class*='_td_col_1']" ); //name
    By paisTabla = By.cssSelector( ".contact_contact [class*='_td_col_3']" ); //pais
    By celularTabla = By.cssSelector( ".contact_contact [class*='_td_col_5']" );
    By correoTabla = By.cssSelector( ".contact_contact [class*='_td_col_7']" );
    By delete = By.cssSelector( ".et2_button et2_button_icon et2_clickable et2_button_delete" );
    By area=By.cssSelector( ".et2_grid addressbook_view" );

    //option[contains(text*(),"Nombre"]

    public AddressBookPage ( ){
        super( driver );
    }


        public void abrirVentanaAgenda (){

            clickJs( agenda );
            click( add );
            String ventana = winHandles( 1 );
            switchToVentana( ventana );
        }

        public String getNombreVentanaAgenda(){
            abrirVentanaAgenda();
            String titulo = getTitulo();
            return titulo;
        }


    public void crearContacto(String organizations,String nombre,String mails,String prefixs,String movils,String bussPhones,String job){

        write( organization,organizations );
        click( name );
        write( prefix,prefixs );
        write(firstName,nombre);
        click(okBoton);
        write(bussPhone,bussPhones);
        write(movil,movils);
        write(mail,mails);
        write( jobTitle,job );
        click( applyBoton );

    }

    public void guardarAgenda(){

        click(saveBoton);
    }

    public String getMensaje (){
        System.out.println( " messageGetText() = " +  messageGetText() );
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        return messageGetText();
    }

    public void cerrarVentanaProyecto(){

        click( cerrarAgenda);
    }

    public void busquedaContactoCreado ( String mail ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        click( busqueda );
        write( busqueda , mail );
        enter( busqueda );

    }

    public List<String> getDatosContacto (){

        List<String> datosContacto = new ArrayList<String>( );
        String nameT = getText(nombreTabla);
        String paisT = getText(paisTabla);
        String celularT = getText(celularTabla);
        String correoT = getText(correoTabla);
        datosContacto.add( nameT );
        datosContacto.add( paisT );
        datosContacto.add( celularT );
        datosContacto.add( correoT );
        return datosContacto;


    }


    public void eliminarContacto ( ){
        String ventana = winHandles( 0 );
        switchToVentana( ventana );
        dobleClick( nombreTabla );
        clickJs( delete );



    }



}
