package page.todoly;

import control.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.id("ctl00_HeaderTopControl1_LinkButtonLogout"));
    public Button settingButton= new Button(By.xpath("//a[text()='Settings']"));

}
