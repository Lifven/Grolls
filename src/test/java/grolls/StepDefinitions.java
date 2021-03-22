package grolls;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    WebDriver driver;
    WebDriverWait waiter;

    @Given("I have navigated to the T-shirt site")
    public void i_have_navigated_to_the_t_shirt_site() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //  waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));
    }

    @Given("I select size Small")
    public void i_select_size_small() throws InterruptedException {
        Select dropdownSize = new Select(driver.findElement(By.cssSelector("select[name='super_attribute[400]'][id=attribute400]")));
        dropdownSize.selectByValue("1419");
        Thread.sleep(1000);
    }

    @Given("the amount is {int}")
    public void the_amount_is(int amount) throws InterruptedException {
        WebElement amountBox = driver.findElement(By.cssSelector("input[type=number]"));
        amountBox.clear();
        amountBox.sendKeys(Integer.toString(amount));
        Thread.sleep(1000);
    }

    @When("I press {string}")
    public void i_press(String string) throws InterruptedException {
        WebElement addButton = driver.findElement(By.cssSelector("button[title='Lägg i varukorgen']"));
        // WebElement addButton = driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div/div[1]/div[2]/div[5]/form/div[2]/div/div/div[2]/button"));
        addButton.click();
        Thread.sleep(3000);
    }

    @Then("the result should be {int} T-shirts in size Small in the cart")
    public void the_result_should_be_t_shirts_in_size_small_in_the_cart(int amount) throws InterruptedException {
        WebElement cartQuantity = driver.findElement(By.cssSelector("span[class='counter qty']"));
        cartQuantity.getAttribute("outerText");
        assertEquals(amount, Integer.parseInt(cartQuantity.getAttribute("outerText")));
        driver.quit();
    }
}
