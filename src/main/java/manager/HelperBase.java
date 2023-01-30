package manager;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HelperBase {


    WebDriver wd;
    //hhh

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void setWd(WebDriver wd) {
        this.wd = wd;
    }



    public void type(By locator, String text){
        if(text!= null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator ){
        wd.findElement(locator).click();
    }
    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size()>0;
    }

    public  void takeScreenShot(String pathToFile){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp.toPath(), screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void pause(int millis){
        try{
            Thread.sleep(millis);}
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
