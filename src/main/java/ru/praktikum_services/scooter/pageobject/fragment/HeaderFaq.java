package ru.praktikum_services.scooter.pageobject.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum_services.scooter.pageobject.page.BasePage;

import java.util.List;

public class HeaderFaq extends BasePage {
    //Локатор для всех вопросов
    private final By questionsLocator = By.xpath(".//*[@class='accordion__button']");
    //Локатор выпадающего ответа
    private final By answerNotHiddenLocator = By.xpath(".//*[@class='accordion__panel' and not(@hidden)]/p");
    public HeaderFaq(WebDriver driver) {
        super(driver);
    }
    //Получаем лист элементов со всеми вопросами на странице
    private List<WebElement> getQuestions(){
      return driver.findElements(questionsLocator);
    }
    //Кликаем по конкретному вопросу, номер вопроса зависит от порядка
    public HeaderFaq clickToQuestionPanel(int index){
        getQuestions().get(index).click();
        return this;
    }
    //Получаем текст выпадающего ответа
    public String getNotHiddenAnswer(){
        return driver.findElement(answerNotHiddenLocator).getText();
    }
}