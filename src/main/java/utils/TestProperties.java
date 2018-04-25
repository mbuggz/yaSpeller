package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
  private static volatile Properties properties;
  private static volatile String propertiesFilePath = "test.properties";

  private static synchronized Properties getProperties() {
    if (properties == null) {
      properties = new Properties();
      try {
        InputStream propertiesFile = TestProperties.class.getClassLoader()
                                         .getResourceAsStream(propertiesFilePath);
        properties.load(propertiesFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return properties;
  }

  private static String getPropertyByName(String propertyName) {
    return getProperties().getProperty(propertyName);
  }

  public static String getSpellerUrl() {
    return getPropertyByName("speller_url");
  }
}
