package com.veraTarasova;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открыть главную страницу Гитхаб")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[data-test-selector=nav-search-input]").setValue(repo).pressEnter();
    }

    @Step("Перейти в репозиторий")
    public void goToRepository() {
        $$(".repo-list li").first().$("a").click();
    }

    @Step("Перейти на вкладку Issues")
    public void goToIssues() {
        $("#issues-tab").click();
    }

    @Step("Проверить название репозитория")
    public void checkOfIssueName() {
        $("#issue_74_link").shouldHave(text("69 nice"));
    }
}
