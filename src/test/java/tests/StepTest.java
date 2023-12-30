package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MyRepoPage;
import pages.SearchPage;
import steps.WebSteps;

import static com.codeborne.selenide.Configuration.baseUrl;
import static data.RepoData.REPOSITORY;
import static data.RepoData.TITLE;
import static io.qameta.allure.Allure.step;

public class StepTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    MyRepoPage repoPage = new MyRepoPage();
    WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Тест с использованием лямбда функции на поиск первого заголовка во вкладке 'Issue' в своём проекте")
    public void stepGithubTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу " + baseUrl, () -> mainPage.openMainPage(baseUrl));
        step("Ищем репозиторий " + REPOSITORY, () -> mainPage.findMyRepo(REPOSITORY));
        step("Кликаем по ссылке найденного репозитория под названием " + REPOSITORY, () ->
                searchPage.findMyRepo(REPOSITORY));
        step("Открываем вкладку Issue в репозитории " + REPOSITORY, () -> repoPage.openIssueTab());
        step("Проверяем, что первый заголовок во вкладке Issue соответствует заголовку " + "'" + TITLE + "'",
                () -> repoPage.checkTitleOfIssue(TITLE));

    }

    @Test
    @DisplayName("Тест с использованием аннтоации на поиск первого заголовка во вкладке 'Issue' в своём проекте")
    public void annotationTest () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage(baseUrl);
        steps.searchRepo(REPOSITORY);
        steps.clickOnRepo(REPOSITORY);
        steps.openIssuesTab();
        steps.checkTitle(TITLE);
    }
}

