import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ArticleTitleTest {

    /* Test is created to check title on delfi.lv home page, article title page and comment page.
     Article titles are checked by second article on home page.
    */

    private WebDriver driver;

    @Test
    public void homePageTitleAndArticlePageTitleCheck() {
        System.setProperty("webdriver.gecko.driver", "d:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.delfi.lv/");
        WebElement homePageTitle = driver.findElement(By.xpath("(.//article[2]//h1[contains(@class,'text-size-19 text-size-md-22 mb-0 mt-2 headline__title')])"));
        String homePageTitleText = homePageTitle.getText();
        homePageTitle.click();
        String articlePageTitle = driver.findElement(By.xpath(".//h1[contains(@class,'text-size-22 text-size-md-30 d-inline')]")).getText();
        Assertions.assertEquals(homePageTitleText, articlePageTitle);
    }

    @Test
    public void homePageTitleAndCommentPageTitleCheck() {
        System.setProperty("webdriver.gecko.driver", "d:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.delfi.lv/");
        WebElement homePageTitle = driver.findElement(By.xpath("(.//article[2]//h1[contains(@class,'text-size-19 text-size-md-22 mb-0 mt-2 headline__title')])"));
        String homePageTitleText = homePageTitle.getText();
        WebElement homePageCommentCount = driver.findElement(By.xpath("(.//article[2]//a[contains(@class,'comment-count text-red-ribbon')])"));
        homePageCommentCount.click();
        String commentPageTitle = driver.findElement(By.xpath(".//h1[@class='article-title']")).getText();
        //commentPageTitle = commentPageTitle.substring(1, commentPageTitle.length()-1);
        Assertions.assertEquals(homePageTitleText, commentPageTitle + " ");
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
