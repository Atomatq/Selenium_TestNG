package org.example.steps;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class Steps {
    @Step("Проверить заголовок вкладки")
    public static void checkTabTitle(WebDriver driver, String text) {
        assertTrue(driver.getTitle().contains(text), "Открыта некорректная страница");
    }

    @Step("Проверить что первый результат содержит: {necessaryResult}")
    public static void checkResultsContains(List<Map<String, Object>> collectResults, String necessaryResult) {
        assertTrue(collectResults.get(0).get("head").toString().contains(necessaryResult), "Request not found in result list");
    }


    @Step("Проверить что первый результат содержит: {necessaryResult}")
    public static void checkTagsContains(List<String> tagsList, String tag) {
        assertTrue(tagsList.contains(tag), "Tag not found. ");
    }
}
