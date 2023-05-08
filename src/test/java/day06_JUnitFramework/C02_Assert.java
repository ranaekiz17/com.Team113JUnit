package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {

 // Amazon'a gidip title'in Amazon icerdigini  test edin

    @Test
    public void test01(){

        /*

            JUnit calistirilan test method(lar)indan kac tanesinin
            passed,failed veya ignore oldugunu otomatik olarak raporlar


            Eger JUnit'in test sonuclarini dogru olarak raporlamasini istiyorsak
            Assert class'indan hazir method'lar kullanarak test yapmaliyiz.

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expectedIcerik = "AMAZON";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("actual Title:  + Test FAILED");
            System.out.println("Test FAILED");
        }


        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        driver.close();
    }
}
