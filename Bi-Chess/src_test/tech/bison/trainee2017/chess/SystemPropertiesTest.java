package tech.bison.trainee2017.chess;

import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class SystemPropertiesTest {
  @Test
  public void testName() throws Exception {
    Properties properties = System.getProperties();

    for (Entry<Object, Object> property : properties.entrySet()) {
      System.out.println(property);
    }
  }
}
