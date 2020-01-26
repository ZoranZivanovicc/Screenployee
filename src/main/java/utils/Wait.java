package utils;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {
  public JavascriptExecutor js;
  static String pageLoadStatus = null;
  WebDriver driver = DriverFactory.getDriver();
  WebDriverWait wait = new WebDriverWait(driver, 45);

  Actions actions = new Actions(driver);

  /**
   * Wait until element is visible and enabled such that you can click it
   * 
   * @param element
   */
  public void forElementEnabled(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  /**
   * Wait until element is selected and enabled
   * 
   * @param element
   */

  public void waitForElementSelected(WebElement element) {
    // wait.until(ExpectedConditions.elementToBeSelected(element));

  }

  /**
   * An expectation for checking if the given text is present in the specified element.
   * 
   * @param element WebElement
   * @param text String
   */
  public void forTextPresentInElement(WebElement element, String text) {
    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
  }

  /**
   * An expectation for checking if the given text is present in the specified elements value
   * attribute.
   * 
   * @param element
   * @param text
   */

  public void forTextPresentInElementValue(WebElement element, String text) {
    wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
  }

  /**
   * Specifies the amount of time the driver should wait when searching for an element if it is not
   * immediately present.
   * 
   * @param time
   */
  public void implicityWait(long time) {
    driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
  }

  public void pageLoad() {


    do {
      js = (JavascriptExecutor) driver;
      pageLoadStatus = (String) js.executeScript("return document.readyState");
      System.out.print(".");
    } while (!pageLoadStatus.equals("complete"));
    System.out.println();
    System.out.println("Page Loaded.");
  }


  /**
   * An expectation for checking if the given text is present in the specified elements value
   * attribute.
   * 
   * @param element
   */




  public void click(WebElement element) {


    actions.moveToElement(element).click().perform();
  }

  /**
   * This method is used when you need to wait some number of seconds
   * 
   * @param seconds
   * @throws InterruptedException
   */
  public void waitForNumberOfSeconds(int seconds) throws InterruptedException {
    Thread.sleep(seconds * 1000);
  }
}
