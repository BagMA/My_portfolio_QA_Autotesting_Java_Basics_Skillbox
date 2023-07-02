import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoeStore {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSizeShoe() {
        driver.findElement(By.id("size")).sendKeys("44");
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.className("error")).getText();
        String expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals("неверный размер при проверке", expectedResult, actualResult);
    }

    @Test
    public void testNegative() {
        driver.findElement(By.id("size")).sendKeys("45");
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.id("size-error")).getText();
        String expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("неверный размер при проверке", expectedResult, actualResult);
    }

}
