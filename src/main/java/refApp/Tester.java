/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 *
 * @author mlyra
 */
public class Tester {
    public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();

    driver.get("http://localhost:4567");
     
    WebElement element = driver.findElement(By.linkText("login"));
    element.click();

    element = driver.findElement(By.name("username"));
    element.sendKeys("pekka");
    element = driver.findElement(By.name("password"));
    element.sendKeys("akkep");
    element = driver.findElement(By.name("login"));
    element.submit();

    driver.quit();
}
}
