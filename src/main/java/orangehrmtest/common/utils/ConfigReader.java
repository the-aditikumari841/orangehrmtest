package orangehrmtest.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}





