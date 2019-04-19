import sort.BubbleSort;
import sort.ISort;

public class Main {

    public static void main(String[] args) {
        sortTest(new BubbleSort());
    }

    private static void sortTest(ISort sort) {
        int[] data = {4,3,5,8,1,2,10,9,7,0,6};
        sort.sort(data);
    }

}
