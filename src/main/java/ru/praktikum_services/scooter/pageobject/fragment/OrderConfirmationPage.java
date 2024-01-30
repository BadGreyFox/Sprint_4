package ru.praktikum_services.scooter.pageobject.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.scooter.pageobject.page.BasePage;

//Класс для описания фрагмента страницы с подтверждением заказа
public class OrderConfirmationPage extends BasePage {
    //локатор успешности оформления заказа
    private final By orderIsProcessed = By.xpath(".//*[text()='Заказ оформлен']");
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }
    //метод для проверки отображения элемента с указанием успешности оформления заказа
    public boolean checkOrderIsProcessed(){
        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}
