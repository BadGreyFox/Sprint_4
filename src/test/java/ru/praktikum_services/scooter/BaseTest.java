package ru.praktikum_services.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum_services.scooter.pageobject.constants.MainPage;

public abstract class BaseTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        driver.get(MainPage.URL);

        setCookie(new Cookie("Cartoshka","true"));
        setCookie(new Cookie("Cartoshka-legacy","true"));
    }
    //метод добавления куки
    private void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
        driver.navigate().refresh(); //обновляем страницу после добавления куки
    }
    @After
    public void tearDown(){
        driver.manage().deleteAllCookies(); //Чистим все куки перед выходом
        driver.quit();
    }
    //паттерн для добавления требуемого браузера
    private WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }
}
