import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadRegisterData {
    @DataProvider(name = "data Register")
    public Object[][] data1(){
        return new Object[][]{
                {"M","Fy","11",8,"1995","mohamedalifahmy2021","ITI","123456","123456"},
                {"","Fy","11",8,"1995","mohamedalifahmy2021@gmail.com","ITI","123456","123456"},
                {"Mohamed","","11",8,"1995","mohamedalifahmy2021@gmail.com","ITI","123456","123456"},
                {"Mohamed","Fahmy","11",8,"1995","mohamedalifahmy2021@gmail.com","ITI","123456","123456"}
        };
    }
}
//    @DataProvider(name = "data")
//
//    public Object[][] getData(Method m) throws IOException {
//
//        String excelSheetName =m.getName();
//        File f =new File(System.getProperty("D:\\iti\\New folder\\MyProjectSelenuiem\\src\\test\\resources\\Register data.xlsx"));
//        FileInputStream file =new FileInputStream(f);
//        Workbook wb = WorkbookFactory.create(file);
//        Sheet sheetName =wb.getSheet(excelSheetName);
//        int totalRows =sheetName.getLastRowNum();
//        Row rowCells =sheetName.getRow(0);
//        int totalCols =rowCells.getLastCellNum();
//        DataFormatter formatter =new DataFormatter();
//
//        String testData[][]=new String[totalRows][totalCols];
//        for(int i=1;i<=totalRows;i++){
//            for (int j=0;j<totalCols;j++){
//                testData[i-1][j]=formatter.formatCellValue(sheetName.getRow(i).getCell(j));
//                System.out.println(testData[i-1][j]);
//            }
//        }
//        return testData;
//    }
//}
