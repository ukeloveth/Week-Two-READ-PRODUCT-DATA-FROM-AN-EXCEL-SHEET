import models.Product;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

//        File file = new File(fileToReadFrom);   //creating a new file instance
//        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//
//        XSSFWorkbook workbook = new XSSFWorkbook(fileToReadFrom);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        for (int i = 1; i <= sheet.getLastRowNum(); i++){
//            XSSFRow row = sheet.getRow(i);
//            Product product = new Product();
//            Category category = new Category();
//            for (int j = 1; j<=row.getLastCellNum(); j++ ){
//                XSSFCell cell =  row.getCell(j);
//                switch(cell.getColumnIndex()){
//                    case 1 :
//                        product.setId((int) cell.getNumericCellValue());
//                        break;
//                    case 2 :
//                        product.setName(cell.getStringCellValue());
//                        break;
//                    case 3 :
//                        product.setBrand(cell.getStringCellValue());
//                    case 4 :
//                        product.setModelName(cell.getStringCellValue());
//                    case 5 :
//                        System.out.println(cell.getStringCellValue());
////                        product.setPrice(cell.getNumericCellValue());
//                        break;
//                    case 6 :
//                        product.setQuantity((int) cell.getNumericCellValue());
//                        break;
//                    case 7 :
//                        category.setName(cell.getStringCellValue());
//                    case 8 :
//                        category.setDescription(cell.getStringCellValue());
//                        product.setCategory(category);
//                        //System.out.println(product);
//                        Product[] productList = store.getProductList();
//                        productList[productList.length-1] = product;
//                        store.setProductList(productList);
//                        //System.out.println(store.getProductList());
//                        break;
//                    default :
//                }
//            }
//        }









//    switch (cell.getColumnIndex()) {
//        case 1 :
//            System.out.println(cell.getNumericCellValue());
//            product.setId((int) cell.getNumericCellValue());
//            break;
//        case 2 :
//            System.out.println(cell.getStringCellValue());
//            product.setName(cell.getStringCellValue());
//            break;
//        case 3 :
//            System.out.println(cell.getStringCellValue());
//            product.setBrand(cell.getStringCellValue());
//        case 4 :
//            System.out.println(cell.getStringCellValue());
//            product.setModelName(cell.getStringCellValue());
//        case 5 :
//            System.out.println(cell.getStringCellValue());
//            //product.setPrice(cell.getNumericCellValue());
//            break;
//        case 6 :
//            System.out.println(cell.getNumericCellValue());
//            product.setQuantity((int) cell.getNumericCellValue());
//            break;
//        case 7 :
//            System.out.println(cell.getStringCellValue());
//            category.setName(cell.getStringCellValue());
//        case 8 :
//            System.out.println(product);
//            System.out.println(cell.getStringCellValue());
//            category.setDescription(cell.getStringCellValue());
//            product.setCategory(category);
//            Product[] productList = store.getProductList();
//            productList[productList.length-1] = product;
//            store.setProductList(productList);
//            //System.out.println(store.getProductList());
//            break;
//        default :
//    }
}
