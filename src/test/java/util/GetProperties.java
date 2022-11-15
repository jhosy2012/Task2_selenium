package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
     private static GetProperties getProperties= null;
     private String browser;
     private String host;
     private String user;
     private String pwd;

     private GetProperties(){
         Properties properties = new Properties();
         String nameFile="todoly.properties";
         InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
         if(inputStream!= null){
             try {
                 properties.load(inputStream);
                 browser=properties.getProperty("browser");
                 host=properties.getProperty("host");
                 user=properties.getProperty("user");
                 pwd=properties.getProperty("pwd");

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }
     }

     public static GetProperties getInstance(){
         if (getProperties == null)
             getProperties=new GetProperties();
         return getProperties;
     }

    public String getBrowser() {
        return browser;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}
