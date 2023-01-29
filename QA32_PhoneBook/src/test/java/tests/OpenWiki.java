package tests;

import manager.TestNgMyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgMyListener.class)
public class OpenWiki {
    WebDriver wd;
    @Test
    public void openWikipedia(){
        wd = new ChromeDriver();
        wd.get("https://www.wikipedia.org/");
    }
}
