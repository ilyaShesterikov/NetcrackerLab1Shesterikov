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

        long countTime;

        switch(st){
            case BubbleSortFloatUp:
                s = new BubbleSortFloatUp();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            case BubbleSortSink:
                s = new BubbleSortSink();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            case BuiltInSort:
                s = new BuiltInSort();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            case QuickSort:
                s = new QuickSort();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            case MergeWithBubbleSortFloatUp:
                s = new MergeWithBubbleSortFloatUp();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            case MergeWithBubbleSortSink:
                s = new MergeWithBubbleSortSink();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            case MergeWithBuiltInSort:
                s = new MergeWithBuiltInSort();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
            default:
                s = new MergeWithQuickSort();
                countTime = System.nanoTime();
                s.sort(array);
                countTime = System.nanoTime() - countTime;
                break;
        }

        return countTime;
    }
}
