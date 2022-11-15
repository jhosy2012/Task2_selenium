package control;

import org.openqa.selenium.By;

public class TextBox extends Control{
    public TextBox(By locator) {
        super(locator);
    }

    public void setText(String value){
        this.find();
        this.control.sendKeys(value);
    }

    public void cleanSetText(String value) {
        this.find();
        this.control.clear();
        this.control.sendKeys(value);
    }

}
