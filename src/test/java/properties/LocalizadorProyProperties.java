package properties;

import org.openqa.selenium.By;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocalizadorProyProperties {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/localizadores.properties";


    public LocalizadorProyProperties (){
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


    public By getProyectoId (){
        String projectById = properties.getProperty( "projectByCss" );
        By locator = By.cssSelector( projectById );
        if(projectById != null) return locator;
        else throw new RuntimeException( "projectByCss not specified in the Configuration.properties file." );
    }

    public By getAdd (){
        String addById = properties.getProperty( "addById" );
        By locator = By.id( addById );
        if(addById != null) return locator;
        else throw new RuntimeException( "addById not specified in the Configuration.properties file." );
    }

    public By getBusqueda (){
        String busquedaByCss = properties.getProperty( "busquedaByCss" );
        By locator = By.cssSelector( busquedaByCss );
        if(busquedaByCss != null) return locator;
        else throw new RuntimeException( "busquedaByCss not specified in the Configuration.properties file." );
    }

    public By getCerrarProyecto (){
        String cerrarProyectoByCss = properties.getProperty( "cerrarProyectoByCss" );
        By locator = By.cssSelector( cerrarProyectoByCss );
        if(cerrarProyectoByCss != null) return locator;
        else throw new RuntimeException( "cerrarProyectoByCss not specified in the Configuration.properties file." );
    }

    public By getIdProyectoCreado (){
        String idProyectoCreadoByCss = properties.getProperty( "idProyectoCreadoByCss" );
        By locator = By.cssSelector( idProyectoCreadoByCss );
        if(idProyectoCreadoByCss != null) return locator;
        else throw new RuntimeException( "idProyectoCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getNombreProyectoCreado (){
        String nombreProyectoCreadoByCss = properties.getProperty( "nombreProyectoCreadoByCss" );
        By locator = By.cssSelector( nombreProyectoCreadoByCss );
        if(nombreProyectoCreadoByCss != null) return locator;
        else
            throw new RuntimeException( "nombreProyectoCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getPriorityCreado (){
        String priorityCreadoByCss = properties.getProperty( "priorityCreadoByCss" );
        By locator = By.cssSelector( priorityCreadoByCss );
        if(priorityCreadoByCss != null) return locator;
        else throw new RuntimeException( "priorityCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getStartDateCreado (){
        String startDateCreadoByCss = properties.getProperty( "startDateCreadoByCss" );
        By locator = By.cssSelector( startDateCreadoByCss );
        if(startDateCreadoByCss != null) return locator;
        else throw new RuntimeException( "startDateCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getEndDateCreado (){
        String endDateCreadoByCss = properties.getProperty( "endDateCreadoByCss" );
        By locator = By.cssSelector( endDateCreadoByCss );
        if(endDateCreadoByCss != null) return locator;
        else throw new RuntimeException( "endDateCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getBudgCreado (){
        String budgCreadoByCss = properties.getProperty( "budgCreadoByCss" );
        By locator = By.cssSelector( budgCreadoByCss );
        if(budgCreadoByCss != null) return locator;
        else throw new RuntimeException( "budgCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getTimesCreado (){
        String timesCreadoByCss = properties.getProperty( "timesCreadoByCss" );
        By locator = By.cssSelector( timesCreadoByCss );
        if(timesCreadoByCss != null) return locator;
        else throw new RuntimeException( "timesCreadoByCss not specified in the Configuration.properties file." );
    }

    public By getTexto (){
        String textoByCss = properties.getProperty( "textoByCss" );
        By locator = By.cssSelector( textoByCss );
        if(textoByCss != null) return locator;
        else throw new RuntimeException( "textoByCss not specified in the Configuration.properties file." );
    }

    public By getTitleTabla (){
        String titleTablaByCss = properties.getProperty( "titleTablaByCss" );
        By locator = By.cssSelector( titleTablaByCss );
        if(titleTablaByCss != null) return locator;
        else throw new RuntimeException( "titleTablaByCss not specified in the Configuration.properties file." );
    }

    public By getDeleteProject (){
        String deleteProjectByXp = properties.getProperty( "deleteProjectByXp" );
        By locator = By.xpath( deleteProjectByXp );
        if(deleteProjectByXp != null) return locator;
        else throw new RuntimeException( "deleteProjectByXp not specified in the Configuration.properties file." );
    }

    public By getOpen (){
        String openByXp = properties.getProperty( "openByXp" );
        By locator = By.xpath( openByXp );
        if(openByXp != null) return locator;
        else throw new RuntimeException( "openByXp not specified in the Configuration.properties file." );
    }

    public By getNoElementosBusqueda (){
        String noElementosBusquedaByXp = properties.getProperty( "noElementosBusquedaByXp" );
        By locator = By.xpath( noElementosBusquedaByXp );
        if(noElementosBusquedaByXp != null) return locator;
        else
            throw new RuntimeException( "noElementosBusquedaByXp not specified in the Configuration.properties file." );
    }

    public By getYesBoton (){
        String yesBotonById = properties.getProperty( "yesBotonById" );
        By locator = By.id( yesBotonById );
        if(yesBotonById != null) return locator;
        else
            throw new RuntimeException( "yesBotonById not specified in the Configuration.properties file." );
    }


}
