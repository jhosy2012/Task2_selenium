package page.todoly;

import control.Button;
import control.CheckBox;
import control.TextBox;
import org.openqa.selenium.By;

public class SignUpSection {
    public TextBox fullNameTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox pwdTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public CheckBox agreeTermsCheckBox= new CheckBox(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signupButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));

    public SignUpSection(){

    }

    public void createNewAccount(String fullName,String email,String pwd){
        fullNameTextBox.setText(fullName);
        emailTextBox.setText(email);
        pwdTextBox.setText(pwd);
        agreeTermsCheckBox.check();
        signupButton.click();
    }


}

