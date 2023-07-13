import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson4_3 {
    static WebDriver driver;
    By nameLocator = By.cssSelector(".data.text");
    By emailLocator = By.cssSelector(".data.field");
    By textLocator = By.cssSelector(".field.text");
    By buttonLocator = By.id("comment");
    By resultText = By.className("message-header");
    String name = "Elina";
    String email = "test@test.ru";
    String text = "не очеень";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCallBack() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(textLocator).sendKeys(text);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("не правильный email", driver.findElement(resultText).isDisplayed());
    }
}
