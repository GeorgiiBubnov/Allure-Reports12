package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import pages.MyRepoPage;
import pages.SearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static data.RepoData.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    MyRepoPage repoPage = new MyRepoPage();

    @Test
    @DisplayName("Простой тест на поиск первой вкладки 'Issue' в своём проекте")
    public void simpleGithubTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("GeorgiiBubnov/Allure-Reports12");
        $("#query-builder-test").pressEnter();
        $(linkText("GeorgiiBubnov/Allure-Reports12")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);


    }

    @Test
    @DisplayName("Тест с использованием 'PageObject' на поиск первой вкладки 'Issue' в своём проекте")
    public void pageObjectGithubTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainPage.openMainPage(baseUrl)
                .findMyRepo(REPOSITORY);
        searchPage.findMyRepo(REPOSITORY);
        repoPage.openIssueTab()
                .checkTitleOfIssue(TITLE);

    }
}
