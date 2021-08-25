package properties;
import org.openqa.selenium.By;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocalizadorAddProyProperties {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/localizadores.properties";


    public LocalizadorAddProyProperties (){
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


    public By getTitulo (){
        String tituloById = properties.getProperty( "tituloById" );
        By locator = By.id( tituloById );
        if(tituloById != null) return locator;
        else throw new RuntimeException( "tituloById not specified in the Configuration.properties file." );
    }
    public By getNum (){
        String numById = properties.getProperty( "numById" );
        By locator = By.id( numById );
        if(numById != null) return locator;
        else throw new RuntimeException( "numById not specified in the Configuration.properties file." );
    }
    public By getSave(){
        String saveById = properties.getProperty( "saveById" );
        By locator = By.id( saveById );
        if(saveById != null) return locator;
        else throw new RuntimeException( "saveById not specified in the Configuration.properties file." );
    }
    public By getMessageSave (){
        String messageSaveById = properties.getProperty( "messageSaveById" );
        By locator = By.id( messageSaveById );
        if(messageSaveById != null) return locator;
        else throw new RuntimeException( "messageSaveById not specified in the Configuration.properties file." );
    }
    public By getMembersSelect (){
        String membersSelectById = properties.getProperty( "membersSelectById" );
        By locator = By.id( membersSelectById );
        if(membersSelectById != null) return locator;
        else throw new RuntimeException( "membersSelectById not specified in the Configuration.properties file." );
    }
    public By getCategory (){
        String categoryById = properties.getProperty( "categoryById" );
        By locator = By.id( categoryById );
        if(categoryById != null) return locator;
        else throw new RuntimeException( "categoryById not specified in the Configuration.properties file." );
    }

    public By getAddMemBoton (){
        String addMemBotonByCss = properties.getProperty( "addMemBotonByCss" );
        By locator = By.cssSelector( addMemBotonByCss );
        if(addMemBotonByCss != null) return locator;
        else throw new RuntimeException( "addMemBotonByCss not specified in the Configuration.properties file." );
    }

    public By getMembers (){
        String membersByXp = properties.getProperty( "membersByXp" );
        By locator = By.xpath( membersByXp );
        if(membersByXp != null) return locator;
        else throw new RuntimeException( "membersByXp not specified in the Configuration.properties file." );
    }

}
