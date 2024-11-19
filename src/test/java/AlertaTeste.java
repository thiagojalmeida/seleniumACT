import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertFrameEWindowsPage;
import pages.MainPage;

public class AlertaTeste extends BaseTest {

    @Test
    public void testOne() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        AlertFrameEWindowsPage alertaPage = new AlertFrameEWindowsPage(driver);

        mainPage.abirPaginaPrincipal();
        mainPage.irParaAlertFrameEWindows();

        alertaPage.abrirMenuAlertas();
        alertaPage.cliclarBtnAlertDeCincoSegundos();

        alertaPage.esperarAlertaCincoSegundos();
        Assert.assertTrue(alertaPage.isAlertaPresenteAposCincoSegundos(), "Alert did not appear after 5 seconds");

        String textoAtual = alertaPage.pegarTextDoAlerta();

        //causar falha no teste ->
        //Assert.assertEquals(textoAtual, "text-error", "Text does not correspond to expected");

        Assert.assertEquals(textoAtual, alertaPage.pegarTextoEsperado(), "Text does not correspond to expected");

        alertaPage.aceitarAlerta();

    }
}
