package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EjemploFrames {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";

    public static void main(String[] args)
    {
        String URL = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//tiempo limite: debe ejecutarse en menos de 15 seg para que selenium lanze una excepcion antes de que no encuentre un elemento
        WebDriverWait waitVar = new WebDriverWait(driver, 10);//como argumento pide el driver inicializado


        try{
            driver.switchTo().frame("iframeResult");//entra al frame donde se encuentra el boton a usar

            WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));//limite para ser apretado hasta que btnTry sea visible y este habilitado
            btnTry.click();
            //Thread.sleep(2000);

            waitVar.until(ExpectedConditions.alertIsPresent());//limite de espera de 10 segundos hasta que alerta aparezca
            Alert alrtWindow = driver.switchTo().alert();//clase para manipular alertas que la almacena en alrtwindo para poder manipularla
            String alrtTexto = alrtWindow.getText();
            System.out.println(alrtTexto);
            alrtWindow.sendKeys("Raul Alejandro Chavez Hernandez");
            alrtWindow.accept();
            //Thread.sleep(2000);

            String FinalText = driver.findElement(By.id("demo")).getText();
            System.out.println(FinalText.contains("Raul")?FinalText :"Hubo algun error");

        } catch(NoSuchElementException ne){//excepcion
            System.err.println("No se encontro el WebElement: " + ne.getMessage());
        } catch(NoSuchFrameException fe){
            System.err.println("No se encontro ningun frame: " + fe.getMessage());
        } catch(NoAlertPresentException al){
            System.err.println("No se encontro la alerta" + al.getMessage());
        } catch(TimeoutException te){
            System.err.println("Se excedio el tiempo de espera " + te.getMessage());
        } catch(WebDriverException we){
            System.err.println("Fallo en Webdriver " + we.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        } finally{
            driver.quit();
        }
    }
}
