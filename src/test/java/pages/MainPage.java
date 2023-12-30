package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement searchInput = $(".search-input-container"),
            containerSearch = $("#query-builder-test");

    public MainPage openMainPage(String url) {
        open(url);
        return this;
    }

    public MainPage findMyRepo(String repo) {
        searchInput.click();
        containerSearch.sendKeys(repo);
        containerSearch.pressEnter();

        return this;

    }

}
