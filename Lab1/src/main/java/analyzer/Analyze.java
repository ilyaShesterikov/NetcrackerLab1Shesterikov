package analyzer;
import fillers.Fill;
import sorters.*;

/**
 * Class analyzer to call all fillers and sort methods and count time of sorting.
 * @author Shesterikov
 *
 */
public class Analyze{

    /**
     *  Sorters that can be used
     */
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

    /**
     *  Fillers that can be used
     */
    public enum FillType{
        /**
         *  Ascending order
         */
        Asc,
        /**
         *  Descending order
         */
        Desc,
        /**
         *  Ascending order with random element in the end
         */
        AscX,
        /**
         *  Random order
         */
        R
    }

    /**
     * Generates array to sort.
     * @param ft enum type of filling {@link FillType}
     * @param n size of array
     * @return sorted array of ints
     * @see fillers.Fill#makeSortedArrayAsc
     * @see fillers.Fill#makeSortedArrayDesc
     * @see fillers.Fill#makeSortedArrayAscX
     * @see fillers.Fill#makeArray
     */
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

    /**
     * Calls sorting method for passed array
     * Sorts the specified array into ascending numerical order.
     * @param array array to be sorted
     * @param st enum type of sorting {@link SortType}
     * @return time of sorting in nanoseconds
     * @see sorters.BubbleSortFloatUp
     * @see sorters.BubbleSortSink
     * @see sorters.BuiltInSort
     * @see sorters.QuickSort
     * @see sorters.MergeWithBubbleSortFloatUp
     * @see sorters.MergeWithBubbleSortSink
     * @see sorters.MergeWithBuiltInSort
     * @see sorters.MergeWithQuickSort
     */

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

    /**
     * Counts time of sorting
     * @param s sorter
     * @param array array to be sorted
     * @return time of sorting in nanoseconds
     */
    private long countTime(AbstractSorter s, int[] array){
        long countTime = System.nanoTime();
        s.sort(array);
        countTime = System.nanoTime() - countTime;
        return countTime;
    }
}