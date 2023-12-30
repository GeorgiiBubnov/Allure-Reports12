package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;


public class SearchPage {
    private final ElementsCollection linkRepoInput = $$("div[data-testid='results-list'] a");

    public SearchPage findMyRepo(String repo) {
        linkRepoInput.findBy(text(repo)).click();

        return this;
    }
}
