package ru.praktikum_services.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.scooter.pageobject.fragment.HeaderFaq;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqAnswersTextTest extends BaseTest{
    //Создаем лист объектов для теста
    private final List<FAQ> faq;
    public FaqAnswersTextTest(List<FAQ> faq) {
        this.faq = faq;
    }
    //описываем класс для объектов теста
    public static class FAQ{
        private final String expectedAnswers;
        //Номер искомого вопроса
        private final int indexOfQuestion;
        //Совпадают ли ответы
        private final boolean isAnswerEqualExpected;
        private FAQ(int indexOfQuestion, boolean isAnswerEqualExpected, String expectedAnswers) {
            this.expectedAnswers = expectedAnswers;
            this.indexOfQuestion = indexOfQuestion;
            this.isAnswerEqualExpected = isAnswerEqualExpected;
        }
    }
    // Тестовые данные, создаем лист с листами для корректной параметризации
    @Parameterized.Parameters()
    public static List<List<FAQ>> getQuestionAndAnswerWithOrder() {
        return List.of(List.of(
                        (new FAQ(0, true, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.")),
                        (new FAQ(1, true, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.")),
                        (new FAQ(2, true, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.")),
                        (new FAQ(3, true, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.")),
                        (new FAQ(4, true, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.")),
                        (new FAQ(5, true, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.")),
                        (new FAQ(6, true, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.")),
                        (new FAQ(7, true, "Да, обязательно. Всем самокатов! И Москве, и Московской области."))
                ),
                List.of(
                        (new FAQ(0, false, "Сутки — 400 рублей. Оплата курьеру")),
                        (new FAQ(1, false, "Пока что у нас так: один заказ — один самокат.")),
                        (new FAQ(2, false, "Допустим, вы оформляете на 9 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.")),
                        (new FAQ(3, false, "Только начиная с завтрашнего дня.")),
                        (new FAQ(4, false, "Пока что да! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.")),
                        (new FAQ(5, false, "Самокат приезжает к вам с полной зарядкой. Этого хватает на девять суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.")),
                        (new FAQ(6, false, "Да, пока самокат не привезли. Штрафа будет.")),
                        (new FAQ(7, false, "Да, обязательно. И Москве, и Московской области."))
                )
        );
    }
    //Проверяем соответствие выпадающих ответов вопросам
    @Test
    public void checkMatchingQuestionsAndAnswers() {
        for (FAQ value : faq) {
            String actualAnswer = new HeaderFaq(driver)
                    .clickToQuestionPanel(value.indexOfQuestion)
                    .getNotHiddenAnswer();
            assertEquals("Действительный ответ не совпадает с ожидаемым", value.isAnswerEqualExpected, actualAnswer.equals(value.expectedAnswers));
        }
    }
}