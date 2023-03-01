package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement locationBox, String value, String methodName) {
        Select select = new Select((locationBox));
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("method is not available");
        }
    }

    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }
    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }
    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    public static void switchById(WebDriver driver){
        String mainPageId=driver.getWindowHandle();
        Set<String> allPageIds=driver.getWindowHandles();
        for (String id:allPageIds){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
    }
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> allPageIds=driver.getWindowHandles();
        for (String id:allPageIds){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }
    public  static void getScreenShot(WebDriver driver, String packageName ){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("/src/main/java/sreenshot"+packageName);
        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getScreenShotForCucumber(WebDriver driver,Scenario scenario) {
        Date currentDate=new Date();
        String screenShotFileName=currentDate.toString().replace(" ","-").replace(":","-");
        if (scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}