import org.example.pages.ImageResultsPage;
import org.example.pages.SearchPage;
import org.example.pages.SearchResultsPage;
import org.example.steps.Steps;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class Tests extends BaseTest {

    @Parameters({"url", "request"})
    @Test(description = "Проверка отображения результатов поиска. ", enabled = false)
    public void test1( String url, String request) {
        SearchPage searchPage = new SearchPage(webDriver, url);
        searchPage.setRequest(request);
        searchPage.submit();
        Steps.checkTabTitle(webDriver, request+" — Яндекс: нашлось ");
        SearchResultsPage resultsPage = new SearchResultsPage(webDriver);
        List<Map<String, Object>> collectResults = resultsPage.getCollectResults();
        Steps.checkResultsContains(collectResults, request);
    }

    @Parameters({"url", "imgSrc"})
    @Test(description = "Проверка отображения результатов поиска. ")
    public void test2( String url, String imgSrc) {
        SearchPage searchPage = new SearchPage(webDriver, url);
        searchPage.seachByImg(imgSrc);
        Steps.checkTabTitle(webDriver, "Яндекс Картинки: поиск по изображению");
        ImageResultsPage imageResultsPage = new ImageResultsPage(webDriver);
        List<String> tagsList = imageResultsPage.getImageTags();
        Steps.checkTagsContains(tagsList, "selenium");
    }

}
