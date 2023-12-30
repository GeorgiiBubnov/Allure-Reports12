package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class MyRepoPage {

    private final SelenideElement linkIssueTab = $("#issues-tab"),
            firstTitleOfIssue = $("#issue_1_link");

    public MyRepoPage openIssueTab() {
        linkIssueTab.click();

        return this;
    }

    public MyRepoPage checkTitleOfIssue(String title) {
        firstTitleOfIssue.shouldHave(text(title));

        return this;
    }


}
