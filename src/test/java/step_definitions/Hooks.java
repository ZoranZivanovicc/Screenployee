package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

import java.net.MalformedURLException;


/**
 * Hooks Class use annotation to define what will be triggered before each scenario and after each
 * scenario
 * 
 * @Before - Is used to instantiate web driver before each scenario calling method from
 *         DriverFactory class, also there is commented method to instantiate remotely driver
 * @After - Is used to shut down driver after each scenario been executed
 * @author Zoran (QA Team, Belgrade)
 *
 */
public class Hooks {
  DriverFactory df = new DriverFactory();

  @Before()
  public void beforeScenario() throws MalformedURLException, InterruptedException {
       df.createDriver("chrome");
    // Uncomment, comment below and comment above if you want to use remote
    // drivers on remote machine
   // df.useRemoteDriver("chrome");

  }

  @After()
  public void afterScenario() {
    df.teardown();

  }

}
