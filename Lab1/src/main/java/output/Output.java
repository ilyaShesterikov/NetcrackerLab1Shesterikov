package output;

import analyzer.Analyze;
import analyzer.Analyze.FillType;
import analyzer.Analyze.SortType;


public class Output {
    public static void main(String[] args) {
        for(FillType ft: FillType.values()){
            for (SortType st : SortType.values()) {
                Analyze a = new Analyze();
                long time = a.analyze(a.makeArray(ft, 1000), st);
                System.out.println("FillType: " + ft + "\tSortType: " + st + "\t" + time);
            }
        }
    }
}
