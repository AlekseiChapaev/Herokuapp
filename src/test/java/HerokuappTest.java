import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class HerokuappTest extends TestOptions {
    private final String URL = "https://formy-project.herokuapp.com/";
    private final List<String> TEST_SCENARIO_NAMES = List.of(
            "Autocomplete",
            "Buttons",
            "Checkbox",
            "Datepicker",
            "Drag and Drop",
            "Dropdown",
            "Enabled and disabled elements",
            "File Upload",
            "Key and Mouse Press",
            "Modal",
            "Page Scroll",
            "Radio Button",
            "Switch Window",
            "Complete Web Form");

    private void getTestingScenario(String TestingScenario) {
        getDriver().get(URL);
        switch (TestingScenario) {
            case "Autocomplete":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Autocomplete')]")).click();
                break;
            case "Buttons":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Buttons')]")).click();
                break;
            case "Checkbox":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Checkbox')]")).click();
                break;
            case "Datepicker":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Datepicker')]")).click();
                break;
            case "Drag and Drop":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Drag and Drop')]")).click();
                break;
            case "Dropdown":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Dropdown')]")).click();
                break;
            case "Enabled and disabled elements":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Enabled and disabled elements')]")).click();
                break;
            case "File Upload":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'File Upload')]")).click();
                break;
            case "Key and Mouse Press":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Key and Mouse Press')]")).click();
                break;
            case "Modal":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Modal')]")).click();
                break;
            case "Page Scroll":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Page Scroll')]")).click();
                break;
            case "Radio Button":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Radio Button')]")).click();
                break;
            case "Switch Window":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Switch Window')]")).click();
                break;
            case "Complete Web Form":
                getDriver().findElement(By.xpath("//li/a[contains(text(), 'Complete Web Form')]")).click();
                break;
            default:
                getDriver().findElements(By.xpath("//div[@class = 'jumbotron-fluid']/li"));
        }
    }

    @Test
    public void testStartPage() {
        getDriver().get(URL);

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Welcome to Formy");
    }

    @Test
    public void testTestingScenarioNames() {
        getDriver().get(URL);
        List<WebElement> listTestingScenario = getDriver().findElements(By.cssSelector(".jumbotron-fluid li"));

        for (int i = 0; i < listTestingScenario.size(); i++) {

            Assert.assertEquals(listTestingScenario.get(i).getText(), TEST_SCENARIO_NAMES.get(i));
        }
    }

    @Test
    public void testRedirectToTestingScenarioAutocomplete() {
        final String testingScenarioName = "Autocomplete";

        getTestingScenario("Autocomplete");
        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div//input")));

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), testingScenarioName);
    }

    @Test
    public void testAutocompleteInputValues() throws InterruptedException {
        List<String> inputValues = List.of("Address", "Street address", "Street address 2", "City", "State", "Zip code", "Country");
        getTestingScenario("Autocomplete");

        List<WebElement> inputFields = getDriver().findElements(By.xpath("//div//input"));
        for(int i = 0; i < inputFields.size(); i++){
            getWait().until(ExpectedConditions.elementToBeClickable(inputFields.get(i))).click();
            inputFields.get(i).sendKeys(inputValues.get(i));
        }

        System.out.println(inputFields.get(2).getText());
    }
}
