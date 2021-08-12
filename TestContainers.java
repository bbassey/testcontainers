import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.testcontainers.containers.ContainerLaunchException;
import org.testcontainers.containers.MySQLContainer;



public class TestContainers {


    // need ~/.testcontainers.properties
    @Test
    public void testDatabase() {
      List<String> bindings = new ArrayList<String>();
      bindings.add("3306");
      MySQLContainer<?>  container = (MySQLContainer) new MySQLContainer<>("mysql:5.5")
          .withDatabaseName("TEST")
          .withUsername("TEST_USER")
          .withPassword("TEST_PASSWORD")
          .withEnv("MYSQL_ROOT_HOST", "%")
          .withInitScript("./test.sql");

      try {
            container.start();
            System.out.println("JDBC URL :" +  container.getJdbcUrl());
            System.out.println("Container Name :" +  container.getContainerName());
            assertTrue(true);

      } catch (ContainerLaunchException e) {
            System.out.println(e);
      } finally {
            System.out.println("about to stop the container");
            container.stop();
            container.close();
      }

     
    }



}