package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DatosContactoproperties {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/datos.properties";


    public DatosContactoproperties (){
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

    public String getNombre (){
        String nombre = properties.getProperty( "nombre" );
        if(nombre != null) return nombre;
        else throw new RuntimeException( "nombre not specified in the Configuration.properties file." );
    }

    public String getMovil (){
        String movil = properties.getProperty( "movil" );
        if(movil != null) return movil;
        else throw new RuntimeException( "movil not specified in the Configuration.properties file." );
    }

    public String getMail (){
        String mail = properties.getProperty( "mail" );
        if(mail != null) return mail;
        else throw new RuntimeException( "mail not specified in the Configuration.properties file." );
    }

    public String getBussPhones (){
        String bussPhones = properties.getProperty( "bussPhones" );
        if(bussPhones != null) return bussPhones;
        else throw new RuntimeException( "bussPhones not specified in the Configuration.properties file." );
    }

    public String getJob (){
        String job = properties.getProperty( "job" );
        if(job != null) return job;
        else throw new RuntimeException( "job not specified in the Configuration.properties file." );
    }

    public String getOrganizations (){
        String organizations = properties.getProperty( "organizations" );
        if(organizations != null) return organizations;
        else throw new RuntimeException( "organizations not specified in the Configuration.properties file." );
    }

    public String getPais (){
        String pais = properties.getProperty( "pais" );
        if(pais != null) return pais;
        else throw new RuntimeException( "pais not specified in the Configuration.properties file." );
    }

}
