package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageResultsPage {
    private WebDriver driver;
    private List<String> tagsList = new ArrayList<>();

    public ImageResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tags = By.xpath("//section[@aria-labelledby=\"cbir-tags-title\"]//a[not(@style)]");

    public List<String> getImageTags() {
        driver.findElements(tags).forEach(elem -> tagsList.add(elem.getText()));
        return tagsList;
    }

}
