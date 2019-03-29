package output;

import analyzer.AnalyzeUsingReflaction;
import analyzer.Reflaction;
import fillers.Fill;
import fillers.Filler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

import java.lang.reflect.Method;

/**
 * This class takes area of sheet and makes bar chart
 * @author Shesterikov
 */
public class ExcelCharts {
    int rowsNumber;
    int columnsnumber;

    /**
     * Constructor
     * @param rowsNumber quantity of rows of sheet area, which have data to chart
     * @param columnsnumber quantity of columns of sheet area, which have data to chart
     */
    public ExcelCharts(int rowsNumber, int columnsnumber) {
        this.rowsNumber = rowsNumber;
        this.columnsnumber = columnsnumber;
    }

    /**
     * Draws chart on sheet
     * @param spreadsheet sheet on which chart will be drawn
     * @param fillMethod filler name to chart title
     * @param rowid quantity of series
     */
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

    /**
     * Makes data for chart legend
     * @param spreadsheet sheet on which chart will be drawn
     * @param chart
     * @param rowid quantity of series
     * @return data for legend
     */
    public XDDFChartData processData(XSSFSheet spreadsheet, XSSFChart chart, int rowid) {
        XDDFDateAxis bottomAxis = chart.createDateAxis(org.apache.poi.xddf.usermodel.chart.AxisPosition.BOTTOM);
        bottomAxis.setTitle("Sorters");
        XDDFValueAxis leftAxis = chart.createValueAxis(org.apache.poi.xddf.usermodel.chart.AxisPosition.LEFT);
        leftAxis.setTitle("Time in nanosec");
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        leftAxis.setTitle("Time in nanosec");
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

