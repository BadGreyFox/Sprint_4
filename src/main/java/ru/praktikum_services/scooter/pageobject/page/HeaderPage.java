package ru.praktikum_services.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends BasePage{
    //локатор кнопки "Заказать" из верхней панели
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    //локатор кнопки "Заказать" в середине страницы
    private final By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    //метод клика по верхней кнопке заказа
    public OrderPagePersonInformation clickTopOrderButton(){
        driver.findElement(orderButtonTop).click();
        return new OrderPagePersonInformation(driver);
    }
    //метод скролла до нижней кнопки заказа
    private void scrollToBottomOrderButton(){
        WebElement element = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //метод клика по нижней кнопке заказа
    public OrderPagePersonInformation clickBottomOrderButton(){
        scrollToBottomOrderButton();
        driver.findElement(orderButtonBottom).click();
        return new OrderPagePersonInformation(driver);
    }
}
