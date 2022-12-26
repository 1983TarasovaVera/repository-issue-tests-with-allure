package com.veraTarasova;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("tarasovavs")
public class SelenideLambdaStepTest {

    final static String REPOSITORY = "eroshenkoam/allure-example";


    @Test
    @Story("Поиск по Issues")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка наличия Issue")
    @Severity(SeverityLevel.BLOCKER)

    public void testGithubSearchIssue() {

        step("1. открыть github", () -> {
            open("https://github.com");
        });
        step("2. найти репозиторий " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").setValue(REPOSITORY).pressEnter();
        });
        step("3. зайти в первый репозиторий", () -> {
            $$(".repo-list li").first().$("a").click();
            takeScreenShot();
        });
        step("4. перейти на вкладку ISSUES", () -> {
            $("#issues-tab").click();
            takeScreenShot();
        });
        step("5. проверка: присутствует issue с названием 69 nice", () -> {
            $("#issue_74_link").shouldHave(text("69 nice"));
        });
    }

    //добавить скриншоты к шагам
    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenShot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

}
