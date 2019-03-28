package output;

import analyzer.AnalyzeUsingReflaction;
import analyzer.Reflaction;
import fillers.Fill;
import fillers.Filler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sorters.AbstractSorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class ExcelOutput {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Reflaction reflaction = new Reflaction();
        for(Method fillMethod : reflaction.getAnnotadedMethods(Fill.class, Filler.class)) {
            XSSFSheet spreadsheet = workbook.createSheet(fillMethod.getName());
            XSSFRow row = spreadsheet.createRow(0);
            ;
            int rowid = 1;
            row.createCell(0);
            List<Class> sorters = reflaction.getClasses(AbstractSorter.class.getClassLoader(), "sorters");
            for (Class cl : sorters) {
                row.createCell(rowid++).setCellValue(cl.getName());
            }
            rowid = 1;
            for (int arraySize = 100; arraySize < 100000; arraySize *= 10) {
                row = spreadsheet.createRow(rowid++);
                int cellid = 1;
                Cell cell;
                row.createCell(0).setCellValue(arraySize);
                for (Class cl : sorters) {
                    AnalyzeUsingReflaction a = new AnalyzeUsingReflaction();
                    int[] array = a.makeArray(fillMethod, arraySize);
                    long time = a.analyze(array, cl);

                    cell = row.createCell(cellid++);
                    cell.setCellValue(time);
                }
            }

            ExcelCharts ec = new ExcelCharts(3, 8);
            ec.makeChart(spreadsheet, fillMethod, rowid);
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("Writesheet.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("sdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
