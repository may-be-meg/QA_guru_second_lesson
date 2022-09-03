package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWebForm {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void Test() {
    open("/automation-practice-form");
    $("#firstName").setValue("Пользователь");
    $("#lastName").setValue("Тестовый");
    $("#userEmail").setValue("test@test.com");
    $(byText("Female")).click();
    $("#userNumber").setValue("8999999999");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption(9);
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOptionContainingText("1993");
    $(".react-datepicker__day--026").click();
    $("#subjectsInput").setValue("Arts").pressEnter();
    $("#subjectsInput").setValue("Social Studies").pressEnter();
    $(byText("Reading")).click();
    $(byText("Music")).click();
    $("#uploadPicture").uploadFile(new File("./src/test/resources/Vulpes_vulpes_laying_in_snow.jpg"));
    $("#currentAddress").setValue("Улица Тестовая");
    $("#react-select-3-input").setValue("NCR").pressEnter();
    $("#react-select-4-input").setValue("Noida").pressEnter();
    $("#submit").click();
    $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text("Пользователь Тестовый"));
    $(".table-responsive").shouldHave(text("test@test.com"));
    $(".table-responsive").shouldHave(text("Female"));
    $(".table-responsive").shouldHave(text("8999999999"));
    $(".table-responsive").shouldHave(text("26 September,1993"));
    $(".table-responsive").shouldHave(text("Arts, Social Studies"));
    $(".table-responsive").shouldHave(text("Reading, Music"));
    $(".table-responsive").shouldHave(text("Vulpes_vulpes_laying_in_snow.jpg"));
    $(".table-responsive").shouldHave(text("Улица Тестовая"));
    $(".table-responsive").shouldHave(text("NCR Noida"));
   }
}
