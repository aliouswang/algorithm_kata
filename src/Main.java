import sort.BubbleSort;
import sort.ISort;
import sort.InsertSort;
import sort.MergeSort;

public class Main {

    public static void main(String[] args) {
        sortTest(new MergeSort());
    }

    private static void sortTest(ISort sort) {
        int[] data = {4,3,5,8,1,2,10,9,7,0,6};
        sort.sort(data);
    }

}
