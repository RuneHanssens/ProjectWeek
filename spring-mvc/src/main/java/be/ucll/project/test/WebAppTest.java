package be.ucll.project.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class WebAppTest {
        private WebDriver driver;
        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/main/java/be/ucll/project/test/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://localhost:8080/project/");
        }

        @After
        public void clean(){
            driver.quit();
        }

        @Test
        public void Activity(){
            driver.get("http://localhost:8080/project/activity/new.htm");

            driver.findElement(By.id("name")).sendKeys("a name");
            driver.findElement(By.id("description")).sendKeys("a description");
            driver.findElement(By.id("date")).sendKeys("13/06/1998");
            driver.findElement(By.id("startTime")).sendKeys("12:00");
            driver.findElement(By.id("endTime")).sendKeys("14:00");
            driver.findElement(By.id("location")).sendKeys("somewhere");
            driver.findElement(By.id("submit")).click();

            assertEquals("a name a description somewhere 13/06/1998 12:00 14:00 Delete Edit", driver.findElement(By.id("0")).getText());

            driver.get("http://localhost:8080/project/activity.htm");
            driver.findElement(By.id("edit0")).click();

            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys("another name");

            driver.findElement(By.id("description")).clear();
            driver.findElement(By.id("description")).sendKeys("another description");

            driver.findElement(By.id("date")).clear();
            driver.findElement(By.id("date")).sendKeys("13/06/1998");

            driver.findElement(By.id("startTime")).clear();
            driver.findElement(By.id("startTime")).sendKeys("12:01");

            driver.findElement(By.id("endTime")).clear();
            driver.findElement(By.id("endTime")).sendKeys("14:01");

            driver.findElement(By.id("location")).clear();
            driver.findElement(By.id("location")).sendKeys("somewhere else");

            driver.findElement(By.id("submit")).click();

            assertEquals("another name another description somewhere else 13/06/1998 12:01 14:01 Delete Edit", driver.findElement(By.id("0")).getText());

            driver.findElement(By.id("delete0")).click();

            assertTrue(!existsElement("0"));
        }

        private boolean existsElement(String id) {
            try {
              driver.findElement(By.id(id));
            } catch (Exception e) {
               return false;
            }
            return true;
        }
}
