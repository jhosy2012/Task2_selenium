package session;

import browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import util.GetProperties;

public class Session {
     private static Session instance=null;
     private WebDriver browser;
     private Session(){
         browser= FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
     }

     public static Session getInstance(){
         if (instance==null)
             instance=new Session();
         return instance;
     }

     public void closeSession(){
         browser.quit();
         instance=null;
     }

    public WebDriver getBrowser() {
        return browser;
    }

    public void acceptAlert() {
        browser.switchTo().alert().accept();
    }
}
