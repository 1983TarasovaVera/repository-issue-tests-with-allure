package com.veraTarasova;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testGithubSearchIssue() {
        //открыть github
        open("https://github.com");
        //найти репозиторий Ерошенко allure-example
        $("[data-test-selector=nav-search-input]").setValue("eroshenkoam/allure-example").pressEnter();
        //зайти в первый репозиторий
        $$(".repo-list li").first().$("a").click();
        //перейти на вкладку ISSUES
        $("#issues-tab").click();
        //проверка: присутствует issue с названием "69 nice"
        $("#issue_74_link").shouldHave(text("69 nice"));
    }
}
