import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson4_5NewSite {
    static WebDriver driver;


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
    public void searchByCss() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(By.cssSelector(".form-input.input-data")).sendKeys("@");
        driver.findElement(By.cssSelector(".form-input.password")).sendKeys("123");
        driver.findElement(By.cssSelector(".form-submit")).click();
        WebElement error = driver.findElement(By.cssSelector(".form-error-password-email"));
        String actualRes = error.getText();
        String expectedRes = "Некорректный email или пароль";
        Assert.assertTrue("Не отобразилось сообщение об ошибке", error.isDisplayed());
        Assert.assertEquals("Не верный результат сравнения", expectedRes,actualRes);
    }

    @Test
    public void searchByTagAndClass() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(By.cssSelector("input.form-input.input-data")).sendKeys("@");
        driver.findElement(By.cssSelector("input.form-input.password")).sendKeys("123");
        driver.findElement(By.cssSelector("button.form-submit")).click();
        WebElement error = driver.findElement(By.cssSelector("pre.form-error-password-email"));
        String actualRes = error.getText();
        String expectedRes = "Некорректный email или пароль";
        Assert.assertTrue("Не отобразилось сообщение об ошибке", error.isDisplayed());
        Assert.assertEquals("Не верный результат сравнения", expectedRes,actualRes);
    }

    @Test
    public void searchById() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(By.cssSelector("#email")).sendKeys("@");
        driver.findElement(By.cssSelector("#password")).sendKeys("123");
        driver.findElement(By.cssSelector("#submit")).click();
        WebElement error = driver.findElement(By.cssSelector("#error"));
        String actualRes = error.getText();
        String expectedRes = "Некорректный email или пароль";
        Assert.assertTrue("Не отобразилось сообщение об ошибке", error.isDisplayed());
        Assert.assertEquals("Не верный результат сравнения", expectedRes,actualRes);
    }

    @Test
    public void searchByAllSelector() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(By.cssSelector("input#email.form-input.input-data")).sendKeys("@");
        driver.findElement(By.cssSelector("input#password.form-input.password")).sendKeys("123");
        driver.findElement(By.cssSelector("button#submit.form-submit")).click();
        WebElement error = driver.findElement(By.cssSelector("pre#error.form-error-password-email"));
        String actualRes = error.getText();
        String expectedRes = "Некорректный email или пароль";
        Assert.assertTrue("Не отобразилось сообщение об ошибке", error.isDisplayed());
        Assert.assertEquals("Не верный результат сравнения", expectedRes,actualRes);
    }
}
