import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuappTest extends TestOptions{

    private final String URL = "https://formy-project.herokuapp.com/";

    @Test
    public void testPage() {
        getDriver().get(URL);

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Welcome to Formy");
    }

}
