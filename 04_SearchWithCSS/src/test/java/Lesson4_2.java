import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson4_2 {
    static WebDriver driver;
    By girlDog = By.id("girl");
    By boyDog = By.id("boy");
    By email = By.name("email");
    By button = By.id("sendMe");
    String emailName = "test@test.ru";
    By resText = By.className("your-email");


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
    public void testDogNameGirl() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(girlDog).click();
        driver.findElement(email).sendKeys(emailName);
        driver.findElement(button).click();
        String actualRes = driver.findElement(resText).getText();
        Assert.assertEquals("не верный e-mail", emailName, actualRes);
    }

    @Test
    public void testDogNameBoy() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(boyDog).click();
        driver.findElement(email).sendKeys(emailName);
        driver.findElement(button).click();
        String actualRes = driver.findElement(resText).getText();
        Assert.assertEquals("не верный e-mail", emailName, actualRes);
    }
}
