package stepDef;

import config.java_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesPOM.homePage;

import java.time.Duration;

public class registParabank extends java_target{
    @Given("User is in parabank homepage")
    public void userIsInParabankHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(paraBank);
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"leftPanel\"]/h2"))
        );
    }

    //POM (Page Object Modeling
    @When("User click register button")
    public void userClickRegisterButton() {
        homePage homepage = new homePage(driver);
        homepage.clickRegister();
    }

    @Then("User is in register page")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/h1"))
        );
    }

    @When("User input name")
    public void userInputName() {
        homePage homepage = new homePage(driver);
        homepage.inputName("Ays", "ta");
    }

    @And("User input detail address")
    public void userInputDetailAddress() {
        driver.findElement(By.id("customer.address.street")).sendKeys("city");
        driver.findElement(By.xpath("//*[@id=\"customer.address.city\"]")).sendKeys("cty");
        driver.findElement(By.xpath("//*[@id=\"customer.address.state\"]")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"customer.address.zipCode\"]")).sendKeys("1");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1");
        driver.findElement(By.id("customer.ssn")).sendKeys("1");
    }

    @And("User fill valid username and password")
    public void userFillValidUsernameAndPassword() {
        driver.findElement(By.id("customer.username")).sendKeys("ays");
        driver.findElement(By.id("customer.password")).sendKeys("ays123");
    }

    @And("User input confirm password")
    public void userInputConfirmPassword() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("ays123");
    }

    @When("User click registered button")
    public void userClickRegisteredButton() {
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("User already registered")
    public void userAlreadyRegistered() {
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/h1"))
        );
        driver.quit();
    }

    @And("User input invalid confirm password")
    public void userInputInvalidConfirmPassword() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("ays12345");
    }

    @Then("User get error password message")
    public void userGetErrorPasswordMessage() {
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"repeatedPassword.errors\"]"))
        );
        driver.quit();
    }
}
