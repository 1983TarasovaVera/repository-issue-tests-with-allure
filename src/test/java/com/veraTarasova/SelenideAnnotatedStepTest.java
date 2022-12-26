package com.veraTarasova;

import org.junit.jupiter.api.Test;

public class SelenideAnnotatedStepTest {
        private final static String REPOSITORY = "eroshenkoam/allure-example";

        @Test
        public void testGithubSearchIssue() {
            WebSteps steps = new WebSteps();
            steps.openMainPage();
            steps.searchForRepository(REPOSITORY);
            steps.goToRepository();
            steps.goToIssues();
            steps.checkOfIssueName();
        }
}
