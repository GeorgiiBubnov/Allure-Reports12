package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.MyRepoPage;
import pages.SearchPage;


public class WebSteps {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    MyRepoPage repoPage = new MyRepoPage();

    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url) {
        mainPage.openMainPage(url);
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepo(String repo) {
        mainPage.findMyRepo(repo);
    }

    @Step("Кликаем по ссылке найденного репозитория под названием {repo}")
    public void clickOnRepo(String repo) {
        searchPage.findMyRepo(repo);
    }

    @Step("Открываем вкладку Issue в репозитории {repo}")
    public void openIssuesTab() {
        repoPage.openIssueTab();
    }

    @Step("Проверяем, что первый заголовок во вкладке Issue соответствует заголовку {title}")
    public void checkTitle(String title) {
        repoPage.checkTitleOfIssue(title);
    }
}
