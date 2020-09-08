package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;//
        String URL = "http://live.demoguru99.com/index.php/mobile.html";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe"; //user.dir obtiene la ruta donde tiene que ejecutar chromedriver.exe
        //System.out.println(System.getProperty("user.dir")+" hola perro");

        System.setProperty("webdriver.chrome.driver",chromePath);//Configuraciones para abrir el chrome
        driver = new ChromeDriver();
        driver.get(URL);//NAVEGA A LA PAGINA
        driver.manage().window().maximize();//para maximizar la ventana

        //clic en el link TV
        driver.findElement(By.linkText("TV")).click();//busca la pestaña de TV y da click

        //click en add to car
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();

        //obtener el precio del objeto
        actualResult = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span")).getText();

        //comparar resultado
        if (actualResult.contentEquals(expectedResult)){
            System.out.println("La prueba pasó");
        }
        else{
            System.out.println("La prueba falló");
        }
        driver.close();
    }
}