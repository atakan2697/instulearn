package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties; // configuration.properties'deki tum key-value'ler yüklendi

    static  {
        String dosyaYolu= "configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);

        } catch (IOException e){
            System.out.println("properties dosyasi okunamadi");
        }
    } // static blok herşeyden önce çalışır ve
                  // configuration.properties dosyasındaki key-value ikililerini properties objesine yükler

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}

