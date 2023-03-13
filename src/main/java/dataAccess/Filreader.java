package dataAccess;

import model.Product;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;

import static model.Product.DataRecordStore;
import static java.lang.System.out;

@Setter
@Getter
public class Filreader {
    private final String file="src/main/resources/execel.xlsx";
    Product product;
    public Filreader(Product product) {
        this.product = product;
    }
    public Filreader(){}


    public List<Product> fileReader(String filreader) throws IOException {

            FileInputStream stream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet =workbook.getSheetAt(0);
            int row = sheet.getLastRowNum();
            for(int i =1;i<row;i++){
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                int price = (int)sheet.getRow(i).getCell(2).getNumericCellValue();
                int quantity = (int)sheet.getRow(i).getCell(3).getNumericCellValue();
                DataRecordStore.add(new Product(name,price,quantity));

            }
        return DataRecordStore;
    }

    public void showProduct() throws IOException {
        String show="";
        List<Product> ProductList = DataRecordStore;
        for(int i =0;i<ProductList.size();i++){
            String name = ProductList.get(i).getName();
            int price = ProductList.get(i).getPrice();
            int qty = ProductList.get(i).getQuantity();
            show+="**** "+name+" **** Price: $"+price+" **** Quantity: "+qty+"\n";
        }
        out.println(show);
    }

    @Override
    public String toString() {
        return "Filreader{" +
                "filreader='" + DataRecordStore + '\'' +
                '}';
    }
}
