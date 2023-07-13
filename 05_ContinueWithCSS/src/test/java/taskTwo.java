import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class taskTwo {
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testOne() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElements(By.cssSelector("#footer > div"));
    }

    @Test
    public void testTwo() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElements(By.cssSelector("li#genres + *"));
    }

    @Test
    public void testThree() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        driver.findElements(By.cssSelector("div.filter-container ~ *"));
    }
}
