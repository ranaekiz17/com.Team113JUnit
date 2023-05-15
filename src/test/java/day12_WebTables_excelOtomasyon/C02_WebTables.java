package day12_WebTables_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {


        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> basliklarList = driver.findElements(By.xpath("//div[@class='rt-thead -header']"));
        for (WebElement eachHeader : basliklarList
        ) {
            System.out.println(eachHeader.getText());
        }
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi:" + basliklarList.get(3).getText());

        //4. Tablodaki tum datalari yazdirin
        int bosolmayabDataSayisi = 0;
        List<WebElement> tabloDatalari = driver.findElements(By.xpath("//div[@role=‘gridcell’]"));
        for (WebElement eachData : tabloDatalari
        ) {
            if (!eachData.getText().isBlank()) {
                System.out.println(eachData.getText());
                bosolmayabDataSayisi++;
            }
        }
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Tbloda bos olmayan Data sayisi:" + bosolmayabDataSayisi);

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarlist = driver.findElements(By.xpath("//div[@role=‘rowgroup’]"));
        System.out.println("Tablodaki satir sayisi:" + satirlarlist);

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi:" + basliklarList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleri = driver.findElements(By.xpath("//div[@role=‘rowgroup’]"));
        System.out.println("====== ucuncu sutun elementleri ==========");
        for (WebElement eachData : tabloDatalari
        ) {
            if (!eachData.getText().isBlank()) {
                System.out.println(eachData.getText());

            }
            // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
            for (int i = 2; i < satirlarlist.size(); i++) {
                WebElement isim =driver.findElement(By.xpath(getDinamikXpath(i,1)));
                if (isim.getText().equalsIgnoreCase("Kierra")){
                    WebElement salary =driver.findElement(By.xpath(getDinamikXpath(i,5)));
                    System.out.println("Kierra'nin maası:"    +salary.getText());
                }

            }

            // 10. bir method olusturun, satir ve sutun sayisini girdigimde bana datayi yazdirsin
            dataYazdir(2,3);


        }

    }

    private void dataYazdir(int satirNo, int sutunNo) {
        String dinamikXPath= "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;
        WebElement istenenElement= driver.findElement(By.xpath(dinamikXPath));
        System.out.println("Istenen hucredeki data : " + istenenElement.getText());
    }

    public String getDinamikXpath(int satirNo, int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;
    }
}
