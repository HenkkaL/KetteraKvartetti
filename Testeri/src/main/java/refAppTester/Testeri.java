/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refAppTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author mlyra
 */
public class Testeri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Voitaisiin periaatteessa rakentaa tänne testaus? Tehtiin kuitenkin testiluokkaan testit selkeyden vuoksi.
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("Tallennetut viitteet"));
        element.click();
        sleep(3);
    }
    
    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
    
}
