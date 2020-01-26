package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {


  public static WebDriver driver = null;
  public static WebDriverWait waitVar = null;
  public String URL, Node;

  /**
   * Method instantiate driver (chrome, firefox or ie) in local
   * 
   * @param browser
   * @throws MalformedURLException
   * @throws InterruptedException
   */

  public void createDriver(String browser) throws MalformedURLException, InterruptedException {
    if (browser.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    }
    else if (browser.equalsIgnoreCase("ie")) {
      WebDriverManager.iedriver().setup();
      driver = new InternetExplorerDriver();
    }
     else if (browser.equalsIgnoreCase("firefox")) {
       WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    }
     else {
      throw new IllegalArgumentException("The Browser Type is Undefined");
    }
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    waitVar = new WebDriverWait(driver, 15);
  }


  public void teardown() {
    driver.quit();

  }

  public static WebDriver getDriver() {
    return driver;
  }

}
