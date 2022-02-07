package data_provider;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

    public static String configFileReader(String URL) {
        try {
            Properties properties = new Properties();
            String propertyFilePath = "./src/test/resources/config.properties";
            InputStream inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
            return properties.getProperty(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
