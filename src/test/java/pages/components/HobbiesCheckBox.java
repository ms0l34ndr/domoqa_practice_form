package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HobbiesCheckBox {
    public void setHobbiesButton(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
    }
}
