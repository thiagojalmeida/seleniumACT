package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage  extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void abirPaginaPrincipal () {
        driver.get("https://demoqa.com/");
    }

    public void irParaAlertFrameEWindows () {
        click( getElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]")));
    }


}
