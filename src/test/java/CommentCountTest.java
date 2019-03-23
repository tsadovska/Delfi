import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommentCountTest {

    private WebDriver driver;

    @Test
    public void homePageCommentCountAndArticlePageCountCheck() {
        System.setProperty("webdriver.gecko.driver", "d:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.delfi.lv/");
        WebElement homePageCommentCount = driver.findElement(By.xpath("(.//article[2]//a[contains(@class,'comment-count text-red-ribbon')])"));
        String homePageCommentCountText = homePageCommentCount.getText().substring(1, homePageCommentCount.getText().length() - 1);
        int homePageCommentCountNumber = Integer.parseInt(homePageCommentCountText);
        WebElement homePageTitle = driver.findElement(By.xpath("(.//article[2]//h1[contains(@class,'text-size-19 text-size-md-22 mb-0 mt-2 headline__title')])"));
        homePageTitle.click();
        WebElement articlePageCommentCount = driver.findElement(By.xpath(".//article//a[contains(@class,'text-size-19 text-size-md-28')]"));
        String articlePageCommentCountText = articlePageCommentCount.getText();
        articlePageCommentCountText = articlePageCommentCountText.substring(1, articlePageCommentCountText.length() - 1);
        int articlePageCommentCountNumber = Integer.parseInt(articlePageCommentCountText);
        Assertions.assertEquals(homePageCommentCountNumber, articlePageCommentCountNumber);
    }

        @Test
        public void homePageCommentCountAndCommentPageCountCheck() {
            System.setProperty("webdriver.gecko.driver", "d:/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://www.delfi.lv/");
            WebElement homePageCommentCount = driver.findElement(By.xpath("(.//article[2]//a[contains(@class,'comment-count text-red-ribbon')])"));
            String homePageCommentCountText = homePageCommentCount.getText().substring(1, homePageCommentCount.getText().length() - 1);
            int homePageCommentCountNumber = Integer.parseInt(homePageCommentCountText);
            homePageCommentCount.click();
            WebElement commentPageAnonymousUsersCommentCount = driver.findElement(By.xpath(".//span[contains(@class,'type-cnt')]"));
            String commentPageAnonymousUsersCommentCountText = commentPageAnonymousUsersCommentCount.getText().substring(1, commentPageAnonymousUsersCommentCount.getText().length() - 1);
            int commentPageAnonymousUsersCommentCountNumber = Integer.parseInt(commentPageAnonymousUsersCommentCountText);
            WebElement commentPageRegisteredUsersCommentCount = driver.findElement(By.xpath("(.//span[contains(@class,'type-cnt')])[2]"));
            String commentPageRegisteredUsersCommentCountText = commentPageRegisteredUsersCommentCount.getText().substring(1, commentPageRegisteredUsersCommentCount.getText().length() - 1);
            int commentPageRegisteredUsersCommentCountNumber = Integer.parseInt(commentPageRegisteredUsersCommentCountText);
            Assertions.assertEquals(homePageCommentCountNumber, commentPageAnonymousUsersCommentCountNumber + commentPageRegisteredUsersCommentCountNumber);
        }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
