package properties;

import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocalizadorAdd_AddressBookProperties {
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/localizadores.properties";


    public LocalizadorAdd_AddressBookProperties (){
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


    public By getOrganizationa (){
        String organizationById = properties.getProperty( "organizationById" );
        By locator = By.id( organizationById );
        if(organizationById != null) return locator;
        else throw new RuntimeException( "organizationById not specified in the Configuration.properties file." );
    }

    public By getName (){
        String nameByCss = properties.getProperty( "nameByCss" );
        By locator = By.cssSelector( nameByCss );
        if(nameByCss != null) return locator;
        else throw new RuntimeException( "nameByCss not specified in the Configuration.properties file." );
    }

    public By getPrefix (){
        String prefixByCss = properties.getProperty( "prefixByCss" );
        By locator = By.cssSelector( prefixByCss );
        if(prefixByCss != null) return locator;
        else throw new RuntimeException( "prefixByCss not specified in the Configuration.properties file." );
    }

    public By getFirstName (){
        String firstNameByCss = properties.getProperty( "firstNameByCss" );
        By locator = By.cssSelector( firstNameByCss );
        if(firstNameByCss != null) return locator;
        else throw new RuntimeException( "firstNameByCss not specified in the Configuration.properties file." );
    }

    public By getOkBoton (){
        String okBotonById = properties.getProperty( "okBotonById" );
        By locator = By.id( okBotonById );
        if(okBotonById != null) return locator;
        else throw new RuntimeException( "okBotonById not specified in the Configuration.properties file." );
    }
    public By getSaveBoton (){
        String saveBotonById = properties.getProperty( "saveBotonById" );
        By locator = By.id( saveBotonById );
        if(saveBotonById != null) return locator;
        else throw new RuntimeException( "saveBotonById not specified in the Configuration.properties file." );
    }

    public By getBussPhone (){
        String bussPhoneById = properties.getProperty( "bussPhoneById" );
        By locator = By.id( bussPhoneById );
        if(bussPhoneById != null) return locator;
        else throw new RuntimeException( "bussPhoneById not specified in the Configuration.properties file." );
    }

    public By getMovil (){
        String movilById = properties.getProperty( "movilById" );
        By locator = By.id( movilById );
        if(movilById != null) return locator;
        else throw new RuntimeException( "movilById not specified in the Configuration.properties file." );
    }

    public By getMail (){
        String mailById = properties.getProperty( "mailById" );
        By locator = By.id( mailById );
        if(mailById != null) return locator;
        else throw new RuntimeException( "mailById not specified in the Configuration.properties file." );
    }

    public By getJobTitle (){
        String jobTitleById = properties.getProperty( "jobTitleById" );
        By locator = By.id( jobTitleById );
        if(jobTitleById != null) return locator;
        else throw new RuntimeException( "jobTitleById not specified in the Configuration.properties file." );
    }

    public By getCerrarCountry (){
        String cerrarCountryByCss = properties.getProperty( "cerrarCountryByCss" );
        By locator = By.cssSelector( cerrarCountryByCss );
        if(cerrarCountryByCss != null) return locator;
        else throw new RuntimeException( "cerrarCountryByCss not specified in the Configuration.properties file." );
    }

    public By getCountry (){
        String countryByCss = properties.getProperty( "countryByCss" );
        By locator = By.cssSelector( countryByCss );
        if(countryByCss != null) return locator;
        else throw new RuntimeException( "countryByCss not specified in the Configuration.properties file." );
    }


}







