package pages;


import util.DatosProyectoProperties;
import util.LocalizadorInicioProperties;



public class InicioPage extends BasePage {


    DatosProyectoProperties credenciales=new DatosProyectoProperties();
    LocalizadorInicioProperties locator=new LocalizadorInicioProperties();

    public InicioPage (){

        super( driver );
    }


    public void IniciarSesion (){

        navigateTo( credenciales.getUrl() );
        write( locator.getLogin() , credenciales.getUser() );
        write( locator.getClave() , credenciales.getClave() );
        click( locator.getBoton() );


    }


}



