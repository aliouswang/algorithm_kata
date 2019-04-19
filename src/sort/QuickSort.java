package sort;

import util.PrintUtil;

public class QuickSort implements ISort{

    @Override
    public void sort(int[] data) {
        PrintUtil.log("before quick sort:", data);
        sort(data,0, data.length - 1);
        PrintUtil.log("before quick sort:", data);
    }

    private void sort(int[] data, int l, int h) {
        if (l >= h) return;
        int pivot = partition(data, l, h);

        sort(data, l, pivot - 1);
        sort(data, pivot + 1, h);
    }

    private int partition(int[] data, int l, int h) {
        int pivot = data[h];
        int i = l;
        for (int j = l; j < h - 1; j++) {
            if (data[j] < pivot) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;

                i = i+1;
            }
        }
        int temp = data[i];
        data[i] = data[h];
        data[h] = temp;
        return i;
    }

}
