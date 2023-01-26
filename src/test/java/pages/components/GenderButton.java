package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GenderButton {
    public void setGenderButton(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }
}
