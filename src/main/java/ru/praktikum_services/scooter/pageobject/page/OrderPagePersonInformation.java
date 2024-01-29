package ru.praktikum_services.scooter.pageobject.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Класс для описания страницы с указанием персональной информации клиентом для заказа
public class OrderPagePersonInformation extends BasePage{
    //локатор для поля ввода Имени
    private final By firstName = By.xpath(".//*[@placeholder='* Имя']");
    //локатор для поля ввода Фамилии
    private final By lastName = By.xpath(".//*[@placeholder='* Фамилия']");
    //локатор для поля ввода адреса доставки
    private final By address = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для кнопки выбора метро
    private final By metroStation = By.xpath(".//*[@placeholder='* Станция метро']");
    //локатор для поля ввода номера телефона
    private final By phoneNumber = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки "Далее"
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPagePersonInformation(WebDriver driver) {
        super(driver);
    }
    //метод для клика и ввода значения в поле "Имя"
    public OrderPagePersonInformation clickAndPutFirstName(String firstName){
            driver.findElement(this.firstName).click();
            driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }
    //метод для клика и ввода значения в поле "Фамилия"
    public OrderPagePersonInformation clickAndPutLastName(String lastName){
            driver.findElement(this.lastName).click();
            driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }
    //метод для клика и ввода значения в поле "Адрес"
    public OrderPagePersonInformation clickAndPutAddress(String address){
        driver.findElement(this.address).click();
        driver.findElement(this.address).sendKeys(address);
        return this;
    }
    //метод для клика и ввода значения в поле "Метро" с помощью Enter
    public OrderPagePersonInformation clickAndPutMetroStationWithEnter(String metroStation){
        driver.findElement(this.metroStation).click();
        driver.findElement(this.metroStation).sendKeys(metroStation);
        driver.findElement(this.metroStation).sendKeys(Keys.ENTER);
        return this;
    }
    //метод для клика и ввода значения в поле "Метро" с помощью через выпадающий список
    public OrderPagePersonInformation clickAndPutMetroStation(String metroStation){
        driver.findElement(this.metroStation).click();
        driver.findElement(this.metroStation).sendKeys(metroStation);

        WebElement element = driver.findElement(this.metroStation);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath(".//*[text()='" + metroStation + "']")).click();
        return this;
    }
    //метод для ввода номера телефона, аргументом принимаем только числа
    public OrderPagePersonInformation clickAndPutPhoneNumber(String phoneNumber){
            driver.findElement(this.phoneNumber).click();
            driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
        return this;
    }
    //метод для нажатия кнопки "Далее"
    public OrderPageAboutRent clickOnButtonNext (){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonNext));
        driver.findElement(buttonNext).click();
        return new OrderPageAboutRent(driver);
    }
}
