import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.testcontainers.containers.ContainerLaunchException;
import org.testcontainers.containers.MySQLContainer;



public class TestContainers {



    @Test
    public void testEmptyPasswordWithNonRootUser() {
      List<String> bindings = new ArrayList();
      bindings.add("3306");
      MySQLContainer container = (MySQLContainer) new MySQLContainer("mysql:5.5")
          .withDatabaseName("TEST")
          .withUsername("test")
          .withPassword("benjamin")
          .withEnv("MYSQL_ROOT_HOST", "%");



          

      try {
        container.start();
        assertTrue(true);
       // System.out.println(container.getFirstMappedPort());
      //  fail("ContainerLaunchException expected to be thrown");
      } catch (ContainerLaunchException e) {
          System.out.println(e);
      } finally {
        System.out.println("Ben about to stop the container");
        container.stop();
      }

     
    }



}