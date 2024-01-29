package ru.praktikum_services.scooter.pageobject.page;

import org.openqa.selenium.*;
import ru.praktikum_services.scooter.pageobject.fragment.OrderPageConfirm;

//Класс с описанием страницы с указанием данных для доставки
public class OrderPageAboutRent extends BasePage{
    //локатор поля даты когда нужно привезти скутер
    private final By whenBringScooter = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    //локатор поля срока аренды
    private final By rentalPeriod = By.className("Dropdown-arrow");
    //локатор поля для комментария курьеру
    private final By commentForCourier = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    //локатор для кнопки "Назад"
    private final By buttonBack = By.cssSelector("[class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    //локатор для кнопки "Заказать"
    private final By buttonOrder = By.cssSelector("[class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPageAboutRent(WebDriver driver) {
        super(driver);
    }
    //Метод клика по полю даты и проставление его значения
    public OrderPageAboutRent clickAndPutDateWhenBringScooter (String date){
        driver.findElement(whenBringScooter).click();
        driver.findElement(whenBringScooter).sendKeys(date);
        driver.findElement(whenBringScooter).sendKeys(Keys.ENTER);
        return this;
    }
    //Метод клика по полю выбора периода аренды и её проставление
    public OrderPageAboutRent clickAndPutRentalPeriod (String rentalPeriod){
        driver.findElement(this.rentalPeriod).click();
        driver.findElement(By.xpath(".//*[text()='" + rentalPeriod + "']")).click();
        return this;
    }
    //Метод клика по чек-боксу с выбором цвета и его проставление
    public OrderPageAboutRent clickAndPutScooterColor(String color){
        driver.findElement(By.xpath(".//*[text()='" + color + "']//parent::label/input")).click();
        return this;
    }
    //Метод клика по полю комментария для курьера и проставление значения в него
    public OrderPageAboutRent clickAndPutCommentForCourier(String commentForCourier){
        driver.findElement(this.commentForCourier).click();
        driver.findElement(whenBringScooter).sendKeys(commentForCourier);
        return this;
    }
    //Метод клика по кнопке "Назад"
    public OrderPagePersonInformation clickButtonBack(){
        driver.findElement(buttonBack).click();
        return new OrderPagePersonInformation(driver);
    }
    //Метод клика по кнопке "Заказать"
    public OrderPageConfirm clickButtonOrder(){
        driver.findElement(buttonOrder).click();
        return new OrderPageConfirm(driver);
    }
}
