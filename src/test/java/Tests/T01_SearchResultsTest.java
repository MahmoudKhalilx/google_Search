package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.DataUtils.getJsonData;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class T01_SearchResultsTest extends T00_BaseTest {



    @Test()
    public void verifySearchResultCountsBetweenPages() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(getDriver());
        String searchQuery = getJsonData("googleSearchData", "searchQuery");


        googleSearchPage
               .EnterSearchContext(searchQuery)
               .goToNextPage();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("start=10"), "User is not on page 2");

        int page2Results = googleSearchPage.getResultsCount();
        System.out.println("Number of results on page 2: " + page2Results);

        googleSearchPage
                .goToNextPage();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("start=20"), "User is not on page 3");

        int page3Results = googleSearchPage.getResultsCount();
        System.out.println("Number of results on page 3: " + page3Results);

        Assert.assertEquals(page3Results, page2Results,
                "Number of results on page 2 (" + page2Results +
                        ") is not equal to page 3 (" + page3Results + ")");
    }



}
