package DataAccess;

import Model.Product;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Filreader {
    private String filreader;
    public Filreader(String filreader) {
        this.filreader = filreader;
    }
    public Filreader(){}
    public String getFilreader() {
        return filreader;
    }
    public void setFilreader(String filreader) {
        this.filreader = filreader;
    }
    public  List<Product> fileReader(String filreader) throws IOException {
        List<Product> listOfItems = new ArrayList<>();

            FileInputStream stream = new FileInputStream(filreader);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet =workbook.getSheetAt(0);
            int row = sheet.getLastRowNum();
            for(int i =1;i<row;i++){
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                int price = (int)sheet.getRow(i).getCell(2).getNumericCellValue();
                int quantity = (int)sheet.getRow(i).getCell(3).getNumericCellValue();
                Product product=new Product(name,price,quantity);
                listOfItems.add(product);
            }

        return listOfItems;

    }

    @Override
    public String toString() {
        return "Filreader{" +
                "filreader='" + filreader + '\'' +
                '}';
    }
}
