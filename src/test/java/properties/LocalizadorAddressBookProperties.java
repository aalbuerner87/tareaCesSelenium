package properties;

import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocalizadorAddressBookProperties {
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/localizadores.properties";


    public LocalizadorAddressBookProperties (){
        BufferedReader reader;
        try {
            reader = new BufferedReader( new FileReader( propertyFilePath ) );
            properties = new Properties();
            try {
                properties.load( reader );
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException( "Configuration.properties not found at " + propertyFilePath );
        }
    }


    public By getAgenda (){
        String agendaByCss = properties.getProperty( "agendaByCss" );
        By locator = By.cssSelector( agendaByCss );
        if(agendaByCss != null) return locator;
        else throw new RuntimeException( "agendaByCss not specified in the Configuration.properties file." );
    }

    public By getAddAg (){
        String addAgById = properties.getProperty( "addAgById" );
        By locator = By.id( addAgById );
        if(addAgById != null) return locator;
        else throw new RuntimeException( "addAgById not specified in the Configuration.properties file." );
    }

    public By getCerrarAgenda (){
        String cerrarAgendaByCss = properties.getProperty( "cerrarAgendaByCss" );
        By locator = By.cssSelector( cerrarAgendaByCss );
        if(cerrarAgendaByCss != null) return locator;
        else throw new RuntimeException( "cerrarAgendaByCss not specified in the Configuration.properties file." );
    }

    public By getBusqueda (){
        String busquedaAdByCss = properties.getProperty( "busquedaAdByCss" );
        By locator = By.cssSelector( busquedaAdByCss );
        if(busquedaAdByCss != null) return locator;
        else throw new RuntimeException( "busquedaAdByCss not specified in the Configuration.properties file." );
    }

    public By getApplyBoton (){
        String applyBotonById = properties.getProperty( "applyBotonById" );
        By locator = By.id( applyBotonById );
        if(applyBotonById != null) return locator;
        else throw new RuntimeException( "applyBotonById not specified in the Configuration.properties file." );
    }

    public By getNombreTabla (){
        String nombreTablaByCss = properties.getProperty( "nombreTablaByCss" );
        By locator = By.cssSelector( nombreTablaByCss );
        if(nombreTablaByCss != null) return locator;
        else throw new RuntimeException( "nombreTablaByCss not specified in the Configuration.properties file." );
    }

    public By getPaisTabla (){
        String paisTablaByCss = properties.getProperty( "paisTablaByCss" );
        By locator = By.cssSelector( paisTablaByCss );
        if(paisTablaByCss != null) return locator;
        else throw new RuntimeException( "paisTablaByCss not specified in the Configuration.properties file." );
    }

    public By getCelularTabla (){
        String celularTablaByCss = properties.getProperty( "celularTablaByCss" );
        By locator = By.cssSelector( celularTablaByCss );
        if(celularTablaByCss != null) return locator;
        else throw new RuntimeException( "celularTablaByCss not specified in the Configuration.properties file." );
    }

    public By getCorreoTabla (){
        String correoTablaByCss = properties.getProperty( "correoTablaByCss" );
        By locator = By.cssSelector( correoTablaByCss );
        if(correoTablaByCss != null) return locator;
        else throw new RuntimeException( "correoTablaByCss not specified in the Configuration.properties file." );
    }

    public By getDelete (){
        String deleteByXp = properties.getProperty( "deleteByXp" );
        By locator = By.xpath( deleteByXp );
        if(deleteByXp != null) return locator;
        else throw new RuntimeException( "deleteByXp not specified in the Configuration.properties file." );
    }

    public By getArea (){
        String areaByCss = properties.getProperty( "areaByCss" );
        By locator = By.cssSelector( areaByCss );
        if(areaByCss != null) return locator;
        else throw new RuntimeException( "areaByCss not specified in the Configuration.properties file." );
    }

    public By getYesBoton (){
        String yesBotonById = properties.getProperty( "yesBotonById" );
        By locator = By.id( yesBotonById );
        if(yesBotonById != null) return locator;
        else throw new RuntimeException( "yesBotonById not specified in the Configuration.properties file." );
    }
}
