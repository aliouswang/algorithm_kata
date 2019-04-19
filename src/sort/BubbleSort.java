package sort;

import util.PrintUtil;

public class BubbleSort implements ISort{

    @Override
    public void sort(int[] data) {
        PrintUtil.log("before bubble sort:", data);
        int len = data.length;
        if (len <= 1) return;
        for (int i = 0; i < len; i++) {
            boolean isSorted = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        PrintUtil.log("before bubble sort:", data);
    }

}
