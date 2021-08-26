package pages;

import org.openqa.selenium.By;
import properties.*;


public class Add_AddressBookPage extends BasePage {
    SelectorAdd_AddressBookProperties locator = new SelectorAdd_AddressBookProperties();
    By organization = locator.getOrganizationa();
    By name = locator.getName();
    By prefix = locator.getPrefix();
    By firstName = locator.getFirstName();
    By okBoton = locator.getOkBoton();
    By saveBoton = locator.getSaveBoton();
    By bussPhone = locator.getBussPhone();
    By movil = locator.getMovil();
    By mail = locator.getMail();
    By jobTitle = locator.getJobTitle();
    By cerrarPais = locator.getCerrarCountry();
    By paisContacto = locator.getCountry();

    public Add_AddressBookPage (){
        super( driver );
    }

    public String generarPrefix (){

        int prefixn = (int) (Math.random() * 1000 + 1);
        String prefix = "prefix" + prefixn;
        return prefix;

    }

    public void agregarNombre ( String nombre , String prefixs ){
        click( name );
        write( prefix , prefixs );
        write( firstName , nombre );
        click( okBoton );

    }

    public void agregarOrganizacion ( String organizations ){
        write( organization , organizations );

    }

    public void agregarmMails ( String mails ){
        write( mail , mails );

    }

    public void agregarMovil ( String movils ){
        write( movil , movils );

    }

    public void agregarTelefNegocio ( String bussPhones ){
        write( bussPhone , bussPhones );

    }

    public void agregarOcupacion ( String job ){
        write( jobTitle , job );

    }

    public void agregarPais ( String paisNuevo ){


        click( cerrarPais );
        write( paisContacto , paisNuevo );


    }

    public void guardarAgenda (){

        click( saveBoton );
    }

}
