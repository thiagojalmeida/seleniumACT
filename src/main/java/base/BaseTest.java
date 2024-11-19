package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("chrome") String browser) throws Exception {
        driver = setupDriver(browser);
        System.out.println("Browser: ["+driver.toString()+"]");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //Thread.sleep(5*1000);
        driver.quit();
    }

    private WebDriver setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        return new EdgeDriver();
    }
}
