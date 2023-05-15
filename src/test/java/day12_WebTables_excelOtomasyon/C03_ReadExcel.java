package day12_WebTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // bilgisayarimizda olan bir dosyaya erisebilmek icin fileInputStream Class'ından obje olusturalim
        String dosyaYolu = System.getProperty("user.dir") +"/src/test/java/day12_WebTables_excelOtomasyon/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // projemize ekledigimiz POI kutuphanelerini kullanarak
        // class'imizin icinde istenen excel'in bir kopyasını olsuturalim

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row  = sheet.getRow(1);
        Cell cell = row.createCell(3);

        System.out.println(cell);

        // 5.index'deki satirin, 1.index'indeki datanin "Luanda" oldugunu test edin
        row= sheet.getRow(5);
        cell= row.getCell(1);
        String expectedData= "Luanda";
        // cell objesinin data turu Cell
        // Java'da farkli data turlerindeki variable'lari equals ile KULLANAMAYIZ
        Assert.assertEquals(expectedData,cell.toString());
        // 12.satir,2.sutundaki bilginin "Baku" oldugunu test edin
        String actualData= sheet.getRow(11).getCell(1).toString();
        expectedData = "Baku";
        Assert.assertEquals(expectedData,actualData);

    }
}
