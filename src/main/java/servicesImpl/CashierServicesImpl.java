package servicesImpl;

import enums.Role;
import exceptions.StaffNotAuthorizedException;
import models.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.CashierServices;
import services.StaffServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static java.sql.JDBCType.NUMERIC;
import static javax.management.openmbean.SimpleType.STRING;

public class CashierServicesImpl implements CashierServices, StaffServices {
    @Override
    public void fetchProductFromStore(Staff staff, Store store,String fileName) throws IOException {
        if (!Role.CASHIER.equals(staff.getRole())){
            throw new StaffNotAuthorizedException("You are not authorized to perform this action");
        }
        String fileToReadFrom = "src/productData/"+fileName;

        try {
            File file = new File(fileToReadFrom);   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            //iterating over Excel file
            Product[] productsList = new Product[sheet.getLastRowNum()];
            for (int i = 1; i <= sheet.getLastRowNum() ; i++) {
                XSSFRow row = sheet.getRow(i);
                Product product = new Product();
                Category category = new Category();
                //System.out.println(row.getSheet());
                //if(row.getRowNum() != 0){
                    for (int j = 1; j < row.getLastCellNum(); j++) {
                        XSSFCell cell = row.getCell(j);
                        switch (cell.getCellType()){
                            case STRING:
                                switch (cell.getColumnIndex()) {
                                    case 2 :
                                        product.setName(cell.getStringCellValue());
                                        break;
                                    case 3 :
                                        product.setBrand(cell.getStringCellValue());
                                    case 4 :
                                        product.setModelName(cell.getStringCellValue());
                                    case 7 :
                                        category.setName(cell.getStringCellValue());
                                    case 8 :
                                        category.setDescription(cell.getStringCellValue());
                                        product.setCategory(category);
                                        productsList[i-1] = product;
                                        store.setProductList(productsList);
                                        break;
                                    default :
                                };
                                break;
                            case NUMERIC:
                                //System.out.println(cell.getNumericCellValue());
                                switch (cell.getColumnIndex()) {
                                    case 1 :
                                        //System.out.println(cell.getNumericCellValue());
                                        product.setId((int) cell.getNumericCellValue());
                                        break;
                                    case 5 :
                                        product.setPrice(cell.getNumericCellValue());
                                        break;
                                    case 6 :
                                        product.setQuantity((int) cell.getNumericCellValue());
                                        break;
                                    default :
                                }
                                break;
                            default: throw new RuntimeException("Exception");
                        }
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printReceipt(Integer customerId, Store store) {
        List<TransactionData> transactionData = store.getTransactionHistory().get(customerId);
        System.out.println();
    }



    @Override
    public void work(Staff staff) {
        System.out.println(staff.getName() + "is working");
    }
}
