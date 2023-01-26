package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;

public class TestBase {

    protected PracticeFormPage formPage = new PracticeFormPage();

    @BeforeAll
    public static void prepareBrowser() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
