package org.testerfabrik.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {
    static WebDriver driver;

    public static void main(String[] args){
        String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
        String URL = "http://demo.guru99.com/test/newtours/";

        System.setProperty("webdriver.chrome.driver",chromePath);// configuracion chrome driver

        driver = new ChromeDriver();//inicia navegador
        driver.get(URL);
        driver.manage().window().maximize();

        try{
            WebElement registro = driver.findElement(By.linkText("REGISTER"));
            registro.click();

            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            txtFirstName.sendKeys("Gil Che Gato");
            Thread.sleep(2000);
            txtFirstName.clear();
            Thread.sleep(2000);
            txtFirstName.sendKeys("Raul Alejandro");

            driver.findElement(By.name("address1")).sendKeys("Navio 4843");

            Select drpCountry = new Select(driver.findElement(By.name("country")));
            Thread.sleep(2000);
            drpCountry.selectByVisibleText("MEXICO");

            driver.findElement(By.id("email")).sendKeys("raulalex2702@gmail.com");
            driver.findElement(By.name("password")).sendKeys("123");

            WebElement repeatPassword = driver.findElement(By.name("confirmPassword"));
            repeatPassword.sendKeys("123");
            //repeatPassword.submit();
            driver.findElement(By.name("submit")).click();
            //Thread.sleep(10000);
            System.out.println("Prueba Exitosa! " + driver.findElement(By.xpath("//*[contains(text(),'Note')]")).getText());


        } catch(NoSuchElementException ne){//excepcion
            System.err.println("No se encontro el WebElement: " + ne.getMessage());
        } catch(WebDriverException we){
            System.err.println("Fallo en Webdriver " + we.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        } finally{
            driver.quit();
        }

    }
}
