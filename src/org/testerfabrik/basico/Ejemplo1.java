package org.testerfabrik.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){
        //Instanciar un objeto del tipo webdriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://demo.guru99.com/test/newtours/";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //Indicar la localizacion del archivo chromedriver.exe en la propiedad webdriver.chrome.driver
        //System.getProperty("user.dir") = c:\..\..\SeleniumBasico   donde se encuentra el archivo o el proyecto
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");//configuracion para que pueda abrir el navegador

        //Abrir el navegador Chrome
         //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

        //navegar a la pagina
        driver.get(baseURL);

        //Extraer el titulo de la pagina
        actualResult = driver.getTitle();

        //imprimir el resultado usando un operador ternario (analogo a un else)//?->verdadero :->falso
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba pasada: " + actualResult :"Prueba erronea!");
        driver.close();
    }
}
