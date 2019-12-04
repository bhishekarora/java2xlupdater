import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.Iterator;

public class UpdateXL {


	
static String oldFilename,newFileName;

    public static void update (String oldName,String newName) throws IOException{
    oldFilename=oldName.trim();
    newFileName=newName.trim();
    String fileName = "meta.xlsx";
    String cellContent = "name";
    int rownr=0, colnr = 0;

    InputStream input = new FileInputStream(fileName);
    
    XSSFWorkbook workbook = new XSSFWorkbook(input);
    XSSFSheet sheet = workbook.getSheetAt(0);
    //Iterator rows = (Iterator) sheet.rowIterator();
    
    
    

  

    updateColumn(sheet, cellContent);
    
    input.close();

    FileOutputStream outFile =new FileOutputStream(new File("meta.xlsx"));
    workbook.write(outFile);
    outFile.close();


    }

public static   void updateColumn(XSSFSheet sheet, String cellContent) {
    for (Row row : sheet) {
        for (Cell cell : row) {
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (cell.getRichStringCellValue().getString().trim().equals(oldFilename)) {
                    cell.setCellValue((String) newFileName); 
                }
            }
        }
    }           
    
  //  return newFileName;
}

}