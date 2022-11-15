package page.todoly;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Label loginLabel = new Label(By.xpath("//img[contains(@src,'pagelogin')]"));
    public Button signUpFreeButton = new Button(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]"));
 }
