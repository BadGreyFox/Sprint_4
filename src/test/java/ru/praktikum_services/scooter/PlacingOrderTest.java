package ru.praktikum_services.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.scooter.pageobject.page.HeaderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PlacingOrderTest extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String dateWhenBringScooter;
    private final String rentalPeriod;
    private final String colorOfScooter;
    private final String commentForCourier;
    private final boolean isOrderProcessedExpected;

    public PlacingOrderTest(String firstName, String lastName, String address, String metroStation, String phoneNumber, String dateWhenBringScooter, String rentalPeriod, String colorOfScooter, String commentForCourier, boolean isOrderProcessedExpected) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dateWhenBringScooter = dateWhenBringScooter;
        this.rentalPeriod = rentalPeriod;
        this.colorOfScooter = colorOfScooter;
        this.commentForCourier = commentForCourier;
        this.isOrderProcessedExpected = isOrderProcessedExpected;
    }

    @Parameterized.Parameters()
    public static Object[][] getDataForOrder() {
        return new Object[][]{
                {"Ярослав", "Ерофеев", "Улица Пушкина, дом колотушкина", "Охотный Ряд", "89778823221", "21.02.2024", "сутки", "чёрный жемчуг", "Привезите целым, пожалуйста", true},
                {"Иван", "Петров", "Улица Льва Толстого, дом Есенина", "Бульвар Рокоссовского", "89772223221", "20.03.2024", "двое суток", "серая безысходность", "Хотя бы привезите", true}
        };
    }

    //Проверка с верхней кнопкой Заказа
    @Test
    public void checkingCorrectnessOrderWithTopButtonPositive() {
        boolean isOrderProcessedActual = new HeaderPage(driver)
                .clickTopOrderButton()
                .clickAndPutFirstName(firstName)
                .clickAndPutLastName(lastName)
                .clickAndPutAddress(address)
                .clickAndPutMetroStation(metroStation)
                .clickAndPutPhoneNumber(phoneNumber)
                .clickOnButtonNext()
                .clickAndPutDateWhenBringScooter(dateWhenBringScooter)
                .clickAndPutRentalPeriod(rentalPeriod)
                .clickAndPutScooterColor(colorOfScooter)
                .clickAndPutCommentForCourier(commentForCourier)
                .clickButtonOrder()
                .clickOrderConfirmationButton()
                .checkOrderIsProcessed();
        assertEquals("Заказ не создан, страница с подтверждением заказа не отобразилась", isOrderProcessedExpected, isOrderProcessedActual);
    }

    //Проверка с нижней кнопкой Заказа
    @Test
    public void checkingCorrectnessOrderWithBottomButtonPositive() {
        boolean isOrderProcessedActual = new HeaderPage(driver)
                .clickBottomOrderButton()
                .clickAndPutFirstName(firstName)
                .clickAndPutLastName(lastName)
                .clickAndPutAddress(address)
                .clickAndPutMetroStation(metroStation)
                .clickAndPutPhoneNumber(phoneNumber)
                .clickOnButtonNext()
                .clickAndPutDateWhenBringScooter(dateWhenBringScooter)
                .clickAndPutRentalPeriod(rentalPeriod)
                .clickAndPutScooterColor(colorOfScooter)
                .clickAndPutCommentForCourier(commentForCourier)
                .clickButtonOrder()
                .clickOrderConfirmationButton()
                .checkOrderIsProcessed();
        assertEquals("Заказ не создан, страница с подтверждением заказа не отобразилась", isOrderProcessedExpected, isOrderProcessedActual);

    }
    //Проверка с использованием кнопки "Назад" на странице с указанием данных для доставки
    @Test
    public void checkingCorrectnessOrderWithUseBackButtonPositive() {
        boolean isOrderProcessedActual = new HeaderPage(driver)
                .clickBottomOrderButton()
                .clickAndPutFirstName(firstName)
                .clickAndPutLastName(lastName)
                .clickAndPutAddress(address)
                .clickAndPutMetroStation(metroStation)
                .clickAndPutPhoneNumber(phoneNumber)
                .clickOnButtonNext()
                .clickButtonBack() //Кликаем на кнопку "Назад"
                .clickOnButtonNext() //Кликаем кнопку Далее снова
                .clickAndPutDateWhenBringScooter(dateWhenBringScooter)
                .clickAndPutRentalPeriod(rentalPeriod)
                .clickAndPutScooterColor(colorOfScooter)
                .clickAndPutCommentForCourier(commentForCourier)
                .clickButtonOrder()
                .clickOrderConfirmationButton()
                .checkOrderIsProcessed();
        assertEquals("Заказ не создан, страница с подтверждением заказа не отобразилась", isOrderProcessedExpected, isOrderProcessedActual);
    }
    //Проверка корректности проставления метро через кнопку "Enter"
    @Test
    public void checkingCorrectnessOrderWithEnterMetroStationPositive() {
        boolean isOrderProcessedActual = new HeaderPage(driver)
                .clickBottomOrderButton()
                .clickAndPutFirstName(firstName)
                .clickAndPutLastName(lastName)
                .clickAndPutAddress(address)
                .clickAndPutMetroStationWithEnter(metroStation)
                .clickAndPutPhoneNumber(phoneNumber)
                .clickOnButtonNext()
                .clickAndPutDateWhenBringScooter(dateWhenBringScooter)
                .clickAndPutRentalPeriod(rentalPeriod)
                .clickAndPutScooterColor(colorOfScooter)
                .clickAndPutCommentForCourier(commentForCourier)
                .clickButtonOrder()
                .clickOrderConfirmationButton()
                .checkOrderIsProcessed();
        assertEquals("Заказ не создан, страница с подтверждением заказа не отобразилась", isOrderProcessedExpected, isOrderProcessedActual);
    }

}
