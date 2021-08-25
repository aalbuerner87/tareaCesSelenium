package properties;

import org.openqa.selenium.By;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocalizadorInicioProperties {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/localizadores.properties";


    public LocalizadorInicioProperties (){
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

    public By getLogin (){
        String loginByXp = properties.getProperty( "loginByXp" );
        By locator = By.xpath( loginByXp );
        if(loginByXp != null) return locator;
        else throw new RuntimeException( "loginByXp not specified in the Configuration.properties file." );
    }

    public By getClave (){
        String claveByXp = properties.getProperty( "claveByXp" );
        By locator = By.xpath( claveByXp );
        if(claveByXp != null) return locator;
        else throw new RuntimeException( "claveByXp not specified in the Configuration.properties file." );
    }

    public By getBoton (){
        String botonByXp = properties.getProperty( "botonByXp" );
        By locator = By.xpath( botonByXp );
        if(botonByXp != null) return locator;
        else throw new RuntimeException( "botonByXp not specified in the Configuration.properties file." );
    }


}

