package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage {
    private final WebDriver driver;
    private final By searchBox = By.xpath("//textarea[@name='q']");
    private final By ResultsList = By.cssSelector("div.g");
    private final By ClickNextPage = By.cssSelector("a#pnnext");
    private int previousPageResultCount = 0;



    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchPage EnterSearchContext(String Search){
        Utility.sendData(driver,searchBox,Search);
        Utility.PressEnter(driver,searchBox);
    return this;
    }

    public GoogleSearchPage goToNextPage() {
        previousPageResultCount = getResultsCount();
        Utility.scrolling(driver,ClickNextPage);
        Utility.clickingOnElement(driver,ClickNextPage);
        return this;
    }

    public List<WebElement> GetListOfResults() {


        return Utility.findWebElements(driver, ResultsList);
    }

    public int getResultsCount() {
        List<WebElement> results = GetListOfResults();
        return results.size();
    }

    public boolean getUrl(String Sart){
        Utility.generalWait(driver);
        return driver.getCurrentUrl().contains(Sart);
    }


    }
