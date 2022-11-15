package page.todoly;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectSection {
    public MenuProjectSection menuProjectSection= new MenuProjectSection();
    public Button addNewProjecButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox nameProjectTxtBox= new TextBox(By.id("NewProjNameInput"));
    public Button addButton = new Button(By.id("NewProjNameButton"));
    public TextBox editProjectTxtBox= new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public Button saveButton= new Button(By.xpath("//td/div/img[@id='ItemEditSubmit']"));

    public ProjectSection(){}

    public void clickOnProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//td[text()='"+nameProject+"']"));
        projectCreated.click();
    }

    public boolean isProjectDisplayedInList(String nameProject){
        Label projectCreated = new Label(By.xpath("//td[text()='"+nameProject+"']"));
        return projectCreated.isControlDisplayed();
    }

    public Label getProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//td[text()='"+nameProject+"']"));
        return projectCreated;
    }

}
