package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DatosProyectoProperties {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/datos.properties";


    public DatosProyectoProperties (){
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

    public String getUser (){
        String user = properties.getProperty( "user" );
        if(user != null) return user;
        else throw new RuntimeException( "user not specified in the Configuration.properties file." );
    }

    public String getClave (){
        String clave = properties.getProperty( "pass" );
        if(clave != null) return clave;
        else throw new RuntimeException( "pass not specified in the Configuration.properties file." );
    }

    public String getUrl (){
        String url = properties.getProperty( "url" );
        if(url != null) return url;
        else throw new RuntimeException( "url not specified in the Configuration.properties file." );
    }

    public String getTituloProyecto (){
        String tituloProyecto = properties.getProperty( "tituloProyecto" );
        if(tituloProyecto != null) return tituloProyecto;
        else throw new RuntimeException( "tituloProyecto not specified in the Configuration.properties file." );
    }

    public String getRecursoAgregado (){
        String recursoAgregado = properties.getProperty( "recursoAgregado" );
        if(recursoAgregado != null) return recursoAgregado;
        else throw new RuntimeException( "recursoAgregado not specified in the Configuration.properties file." );


    }

    public String getIdProyectoConsulta (){
        String idProyectoConsulta = properties.getProperty( "idProyectoConsulta" );
        if(idProyectoConsulta != null) return idProyectoConsulta;
        else throw new RuntimeException( "idProyectoConsulta not specified in the Configuration.properties file." );


    }

    public String getNombreProyectoConsulta (){
        String nombreProyectoConsulta = properties.getProperty( "nombreProyectoConsulta" );
        if(nombreProyectoConsulta != null) return nombreProyectoConsulta;
        else throw new RuntimeException( "nombreProyectoConsulta not specified in the Configuration.properties file." );


    }

    public String getPriority (){
        String priority = properties.getProperty( "priority" );
        if(priority != null) return priority;
        else throw new RuntimeException( "priority not specified in the Configuration.properties file." );


    }

    public String getStartDate (){
        String startDate = properties.getProperty( "startDate" );
        if(startDate != null) return startDate;
        else throw new RuntimeException( "startDate not specified in the Configuration.properties file." );


    }

    public String getEndDateCreado (){
        String endDateCreado = properties.getProperty( "endDateCreado" );
        if(endDateCreado != null) return endDateCreado;
        else throw new RuntimeException( "endDateCreado not specified in the Configuration.properties file." );


    }

    public String getBudg (){
        String budg = properties.getProperty( "budg" );
        if(budg != null) return budg;
        else throw new RuntimeException( "budg not specified in the Configuration.properties file." );


    }

    public String getTimes (){
        String times = properties.getProperty( "times" );
        if(times != null) return times;
        else throw new RuntimeException( "times not specified in the Configuration.properties file." );


    }


}
