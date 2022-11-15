package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class BasicSeleniumTest2 {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        // implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // page load wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://todoist.com/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {

        // login
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/nav[2]/div/ul[2]/li[1]/a")).click();
        driver.findElement(By.id("element-0")).sendKeys("jsmp.jhosy@gmail.com");
        driver.findElement(By.id("element-3")).sendKeys("Hola1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // create
        String nameProject="Proyect";
        driver.findElement(By.id("left_menu_inner")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div[1]/button")).click();
        driver.findElement(By.id("edit_project_modal_field_name")).sendKeys(nameProject);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        int actualResult=driver.findElements(By.xpath(" //span[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        //updateproyect
        nameProject="project2";
        driver.findElement(By.xpath("//*[@id='editor']/div[2]/header/div/div/button[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Editar proyecto']")).click();
        driver.findElement(By.id("edit_project_modal_field_name")).clear();
        driver.findElement(By.id("edit_project_modal_field_name")).sendKeys(nameProject);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        actualResult=driver.findElements(By.xpath(" //span[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        // create task
        String Task="Task";
        driver.findElement(By.xpath("//*[@id=\"editor\"]/div[2]/div/div/ul/li/section/div/ul/li/button")).click();
        driver.findElement(By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).sendKeys(Task);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        actualResult=driver.findElements(By.xpath(" //div[text()='"+Task+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1);



        //update task
        Actions action = new Actions(driver);
        action.moveToElement(
            driver.findElement(By.xpath("//div[contains(@class, 'task_content') and text()='" +  Task + "']"))
        ).perform();
        driver.findElement(By.xpath("//div[contains(@class,'task_list_item__actions')]/button[@data-action-hint='task-edit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains (@class, 'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]//span//span[text()='"+  Task +"']")).clear();
        Task="Update";

        driver.findElement(By.xpath("//div[@class='public-DraftEditorPlaceholder-root']")).sendKeys(Task);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //deleteTask
        action.moveToElement(
                driver.findElement(By.xpath("//div[contains(@class, 'task_content') and text()='" +  Task + "']"))
        ).perform();
        driver.findElement(By.xpath("//div[contains(@class,'task_list_item__actions')]/button[@data-action-hint='task-overflow-menu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@ data-action-hint='task-overflow-menu-delete']")).click();
        Thread.sleep(1000);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //deleteproyect
        driver.findElement(By.xpath("//*[@id='editor']/div[2]/header/div/div/button[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Eliminar proyecto']")).click();
        driver.findElement(By.xpath("//span[text()='Eliminar'] ")).click();
        Thread.sleep(2000);
    }
}
