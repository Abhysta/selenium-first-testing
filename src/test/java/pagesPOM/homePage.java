package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver){
        this.driver = driver;
    }

    //locator
    By buttonRegister = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    public void clickRegister(){
        driver.findElement(buttonRegister).click();
    }

    By firstNameField = By.id("customer.firstName");
    By lastNameField = By.id("customer.lastName");
    public void inputName(String firstName, String lastName){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
    }
}
