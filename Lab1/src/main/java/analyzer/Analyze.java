package analyzer;
import fillers.Fill;
import sorters.*;


public class Analyze{

    public enum SortType{
        BubbleSortFloatUp,
        BubbleSortSink,
        BuiltInSort,
        QuickSort,
        MergeWithBubbleSortFloatUp,
        MergeWithBubbleSortSink,
        MergeWithBuiltInSort,
        MergeWithQuickSort,
    }

    public enum FillType{
        Asc,
        Desc,
        AscX,
        R
    }
    public int[] makeArray( FillType ft, int n){
        int[] array;
        Fill f = new Fill();

        switch(ft){
            case Asc:
                array = f.makeSortedArrayAsc(n);
                break;
            case Desc:
                array = f.makeSortedArrayDesc(n);
                break;
            case AscX:
                array = f.makeSortedArrayAscX(n);
                break;
            default:
                array = f.makeArray(n);
                break;
        }
        return array;
    }

    public long analyze(int[] array, SortType st){
        AbstractSorter s;

        switch(st){
            case BubbleSortFloatUp:
                s = new BubbleSortFloatUp();
                return countTime(s, array);
            case BubbleSortSink:
                s = new BubbleSortSink();
                return countTime(s, array);
            case BuiltInSort:
                s = new BuiltInSort();
                return countTime(s, array);
            case QuickSort:
                s = new QuickSort();
                return countTime(s, array);
            case MergeWithBubbleSortFloatUp:
                s = new MergeWithBubbleSortFloatUp();
                return countTime(s, array);
            case MergeWithBubbleSortSink:
                s = new MergeWithBubbleSortSink();
                return countTime(s, array);
            case MergeWithBuiltInSort:
                s = new MergeWithBuiltInSort();
                return countTime(s, array);
            default:
                s = new MergeWithQuickSort();
                return countTime(s, array);
        }
    }

    private long countTime(AbstractSorter s, int[] array){
        long countTime = System.nanoTime();
        s.sort(array);
        countTime = System.nanoTime() - countTime;
        return countTime;
    }
}
