package utils;

import lombok.Data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Data
public class PropertyUtils {
    private long waitTimeout;
    private long pollingTime;
    private long maxTimeout;

    public PropertyUtils() {
        try {
            Properties properties = new Properties();
            FileReader reader = new FileReader("src/main/resources/env.properties");
            properties.load(reader);

            waitTimeout = Long.parseLong(properties.getProperty("WAIT.TIMEOUT"));
            pollingTime = Long.parseLong(properties.getProperty("POLLING.TIME"));
            maxTimeout = Long.parseLong(properties.getProperty("MAX.TIMEOUT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
