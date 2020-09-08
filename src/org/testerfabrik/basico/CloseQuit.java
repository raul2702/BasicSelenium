package org.testerfabrik.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
    static WebDriver driver;
    static String URL = "http://www.popuptest.com/popuptest2.html";
    static String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";

    public static void close(){
        driver = new ChromeDriver();// abro el navegador
        driver.navigate().to(URL);
        driver.close();
    }

    public static void quit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(URL);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath);//configuracion para usar navegador
        quit();
    }
}
