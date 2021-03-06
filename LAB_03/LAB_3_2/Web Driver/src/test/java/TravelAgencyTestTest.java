// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TravelAgencyTestTest {

  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void travelAgencyTest() {
    driver.get("https://blazedemo.com/");
    driver.manage().window().setSize(new Dimension(1555, 691));
    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
    }

    driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
    driver.findElement(By.id("inputName")).click();
    driver.findElement(By.id("inputName")).sendKeys("Eleandro");
    driver.findElement(By.id("address")).click();
    driver.findElement(By.id("address")).sendKeys("Rua");
    driver.findElement(By.id("address")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("address")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("address")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("address")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("address")).sendKeys("Rua Alfazema 3");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Aveiro");
    driver.findElement(By.id("state")).click();
    driver.findElement(By.id("state")).sendKeys("Aveiro");
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys("3810-042");

    {
      WebElement dropdown = driver.findElement(By.id("cardType"));
      dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
    }

    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
    driver.findElement(By.id("creditCardNumber")).click();
    driver.findElement(By.id("creditCardNumber")).sendKeys("23456789876543");
    driver.findElement(By.id("creditCardMonth")).click();
    driver.findElement(By.id("creditCardMonth")).sendKeys("12");
    driver.findElement(By.id("creditCardYear")).click();
    driver.findElement(By.id("creditCardYear")).sendKeys("2024");
    driver.findElement(By.id("nameOnCard")).click();
    driver.findElement(By.id("nameOnCard")).sendKeys("Eleandro Laureano");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector(".hero-unit")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Thank you for your purchase today"));
  }
}
