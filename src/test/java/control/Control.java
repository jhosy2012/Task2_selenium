package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.Session;

import java.time.Duration;

public class Control {
    protected WebElement control;
    protected By locator;

    public Control(By locator){
        this.locator=locator;
    }

    protected void find(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }

    public void click(){
        this.find();
        control.click();
    }

    public boolean isControlDisplayed(){
       try {
           this.find();
           return control.isDisplayed();
       } catch (Exception e) {
           return false;
       }
    }

    public String getText(){
        this.find();
        return this.control.getText();
    }


    public void waitControlIsNotInThePage(){
        WebDriverWait explicitWait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(this.locator)));
    }

}
