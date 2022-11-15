package page.todoly;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class SettingsSection {

    public TextBox oldPasswordTxtBox= new TextBox(By.id("TextPwOld"));
    public TextBox newPasswordTxtBox= new TextBox(By.id("TextPwNew"));
    public Button okButton = new Button(By.xpath("//span[text()='Ok']"));
}
