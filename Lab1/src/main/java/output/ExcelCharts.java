package output;

import analyzer.AnalyzeUsingReflaction;
import analyzer.Reflaction;
import fillers.Fill;
import fillers.Filler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.BarDirection;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.XDDFBarChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sorters.AbstractSorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelCharts {
    int rowsNumber;
    int columnsnumber;

    public ExcelCharts(int rowsNumber, int columnsnumber) {
        this.rowsNumber = rowsNumber;
        this.columnsnumber = columnsnumber;
    }

    public void makeChart(XSSFSheet spreadsheet, Method fillMethod, int rowid) {
        XSSFDrawing drawing = spreadsheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 20, 30);

        XSSFChart chart = drawing.createChart(anchor);
        chart.setTitleText(fillMethod.getName());
        chart.setTitleOverlay(false);
        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(org.apache.poi.xddf.usermodel.chart.LegendPosition.TOP_RIGHT);

        XDDFBarChartData bar = (XDDFBarChartData) processData(spreadsheet, chart, rowid);
        bar.setBarDirection(BarDirection.COL);

    }

    public XDDFChartData processData(XSSFSheet spreadsheet, XSSFChart chart, int rowid) {
        XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(org.apache.poi.xddf.usermodel.chart.AxisPosition.BOTTOM);
        bottomAxis.setTitle("Sorters");
        XDDFValueAxis leftAxis = chart.createValueAxis(org.apache.poi.xddf.usermodel.chart.AxisPosition.LEFT);
        leftAxis.setTitle("Array size");
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);

        XDDFDataSource<String> xs = XDDFDataSourcesFactory.fromStringCellRange(spreadsheet, new CellRangeAddress(0, 0, 1, columnsnumber));

        for (int i = 1; i < rowid; i++) {
            XDDFNumericalDataSource<Double> ys = XDDFDataSourcesFactory.fromNumericCellRange(spreadsheet, new CellRangeAddress(i, i, 1, columnsnumber));
            XDDFChartData.Series series1 = data.addSeries(xs, ys);
            series1.setTitle(""+spreadsheet.getRow(i).getCell(0).getNumericCellValue(), null);
        }

        chart.plot(data);
        return data;
    }
}

