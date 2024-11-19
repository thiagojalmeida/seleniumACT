package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class AlertFrameEWindowsPage extends BasePage {
    private Alert alert;
    private final int ALERT_WAIT_TIME = 5;
    private final String TEXTO_ESPERADO = "This alert appeared after 5 seconds";

    public AlertFrameEWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void abrirMenuAlertas() {

       click( getElement(By.xpath("//span[normalize-space()='Alerts']")));
   }

   public void cliclarBtnAlertDeCincoSegundos() {
       //On button click, alert will appear after 5 seconds
       WebElement alertBtn = getElement(By.xpath("//button[@id='timerAlertButton']"));
       scrollToElementJS(alertBtn);
       click(alertBtn);
   }

   public void esperarAlertaCincoSegundos() {
       esperar(ALERT_WAIT_TIME);
   }

   public Boolean isAlertaPresenteAposCincoSegundos () {
       try {
           alert = driver.switchTo().alert();
           return  true;
       } catch (NoAlertPresentException nap) {
           System.out.println("[NoAlertPresentException] 5 seconds time");
       }
       return false;
   }

    public String pegarTextDoAlerta() {
        return alert.getText();
    }

    public String pegarTextoEsperado() {
       return this.TEXTO_ESPERADO;
    }

    public void aceitarAlerta() {
       alert.accept();
    }

}
