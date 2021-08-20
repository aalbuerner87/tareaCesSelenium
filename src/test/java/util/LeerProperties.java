package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeerProperties {


    /* public static void main(String[] args) {


         try {
             properties.load(new FileInputStream(new File("src/test/resources/datos.properties")));

             System.out.println(properties.get("user"));
             System.out.println(properties.get("pass"));

         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         leerProperties();

     }*/


    public  Properties leerProperties (){

        Properties properties = new Properties();
        try {
            properties.load( new FileInputStream( new File( "src/test/resources/datos.properties" ) ) );

            System.out.println( properties.get( "user" ) );
            System.out.println( properties.get( "pass" ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

}





