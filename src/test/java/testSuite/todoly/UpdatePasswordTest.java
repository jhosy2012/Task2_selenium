package testSuite.todoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UpdatePasswordTest extends TestBase{


    @Test
    public void verifyUpdatePassword(){
        String email= "bootcamp@"+new Date().getTime()+".com";
        String pwd=new Date().getTime()+"";
        String newPwd= "Auto"+pwd;

        mainPage.signUpFreeButton.click();
        signUpSection.createNewAccount(email,email,pwd);
        menuSection.settingButton.click();
        settingsSection.oldPasswordTxtBox.setText(pwd);
        settingsSection.newPasswordTxtBox.setText(newPwd);
        settingsSection.okButton.click();

        menuSection.logoutButton.click();
        mainPage.loginLabel.click();
        loginSection.login(email,newPwd);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"ERROR no se pudo iniciar sesion");
    }


}
