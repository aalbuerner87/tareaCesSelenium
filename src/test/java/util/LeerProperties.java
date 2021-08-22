package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeerProperties {


    public Properties leerDatos (){

        Properties properties = new Properties();
        try {

            properties.load( new FileInputStream( new File( "src/test/resources/datos.properties" ) ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

    public Properties leerConfig (){

        Properties properties = new Properties();
        try {

            properties.load( new FileInputStream( new File( "src/test/resources/config.properties" ) ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

}





