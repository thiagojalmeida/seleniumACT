package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    protected void abrirPagina(String url) {
        driver.get(url);
    }

    protected void rolarBarra() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, 500)");
    }

    protected void scrollToElementJS(WebElement element) {
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }

    }

    protected void esperar(int seconds ) {
        try { Thread.sleep(seconds*1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
    }

    protected WebElement getElement (By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}

