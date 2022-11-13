import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HerokuappTest extends TestOptions{

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

    public WebElement getTestingScenario(String scenarioName){
        List<WebElement> listTestingScenario = getDriver().findElements(By.cssSelector(".jumbotron-fluid li"));
        for(WebElement w : listTestingScenario){
            if(w.getText().equals(scenarioName)){
                return w;
            }
        }
        return null;
    }

    @Test
    public void testStartPage() {
        getDriver().get(URL);

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Welcome to Formy");
    }

    @Test
    public void testTestingScenarioNames(){
        getDriver().get(URL);
        List<WebElement> listTestingScenario = getDriver().findElements(By.cssSelector(".jumbotron-fluid li"));

        for(int i = 0; i < listTestingScenario.size(); i++){

            Assert.assertEquals(listTestingScenario.get(i).getText(), TEST_SCENARIO_NAMES.get(i));
        }
    }
}
