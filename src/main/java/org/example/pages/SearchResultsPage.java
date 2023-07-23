package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class SearchResultsPage {
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchResults = By.xpath("//ul[@id=\"search-result\"]/li");
    private By head = By.xpath(".//div[contains(@class, \"ic__title-wrapper\")]//a");
    private By description = By.xpath(".//div[contains(@class, \"TextContainer\")]");

    private WebDriver driver;
    private List<Map<String, Object>> resourceList = new ArrayList<>();

    public List<Map<String, Object>> getCollectResults() {
        driver.findElements(searchResults)
                .stream()
                .forEach(elem -> resourceList.add(Map.of(
                        "head", elem.findElement(head).getText(),
                        "description", elem.findElement(description).getText(),
                        "url", elem.findElement(head).getAttribute("href").toString()
                )));

        return resourceList;
    }


}
