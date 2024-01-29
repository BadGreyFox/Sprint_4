package ru.praktikum_services.scooter.pageobject.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum_services.scooter.pageobject.page.BasePage;

import java.time.Duration;

//Класс для описания фрагмента страницы для подтверждения заказа
public class OrderPageConfirm extends BasePage {
    //локатор для кнопки подтверждения заказа
    private final By orderConfirmationButton = By.xpath(".//button[text()='Да']");
    public OrderPageConfirm(WebDriver driver) {
        super(driver);
    }
    //Метод клика по кнопке подтверждения заказа
    public OrderConfirmationPage clickOrderConfirmationButton (){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderConfirmationButton));
        driver.findElement(orderConfirmationButton).click();
        return new OrderConfirmationPage(driver);
    }
    //Метод клика по кнопке отказа от подтверждения заказа
}
