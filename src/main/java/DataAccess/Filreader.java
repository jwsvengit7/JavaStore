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
    private List<Product> ProductList;
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

    public List<Product> fileReader(String filreader) throws IOException {
        ProductList = new ArrayList<>();
        String show="";

            FileInputStream stream = new FileInputStream(filreader);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet =workbook.getSheetAt(0);
            int row = sheet.getLastRowNum();
            for(int i =1;i<row;i++){
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                int price = (int)sheet.getRow(i).getCell(2).getNumericCellValue();
                int quantity = (int)sheet.getRow(i).getCell(3).getNumericCellValue();
                Product product=new Product(name,price,quantity);
                ProductList.add(product);
            }
        return ProductList;
    }

    public void showProduct() throws IOException {
        String show="";
        Filreader filreader = new Filreader("src/main/resources/execel.xlsx");
        String file = filreader.getFilreader();
        filreader.setFilreader(file);
        List<Product> ProductList =  filreader.fileReader(filreader.getFilreader());
        for(int i =0;i<ProductList.size();i++){
            String name = ProductList.get(i).getName();
            int price = ProductList.get(i).getPrice();
            int qty = ProductList.get(i).getQuantity();
            show+="**** "+name+" **** Price: $"+price+" **** Quantity: "+qty+"\n";
        }
        System.out.println(show);
    }

    @Override
    public String toString() {
        return "Filreader{" +
                "filreader='" + filreader + '\'' +
                '}';
    }
}
