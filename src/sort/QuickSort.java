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
        int pivot = data[l];
        int left = l;
        while (l != h) {
            while (l < h && data[h] >= pivot) {
                h--;
            }

            while (l < h && data[l] <= pivot) {
                l++;
            }

            if (l < h) {
                int temp = data[l];
                data[l] = data[h];
                data[h] = temp;
            }
        }
        data[left] = data[l];
        data[l] = pivot;

        return l;
    }

//    private int partition(int[] data, int l, int h) {
//        int pivot = data[l];
//        int i = l;
//        int j = h;
//        while (i < j) {
//            while (i<j && data[j] >= pivot) {
//                j--;
//            }
//            data[i] = data[j];
//
//            while (i < j && data[i] < pivot) {
//                i++;
//            }
//            data[j] = data[i];
//        }
//        data[j] = pivot;
//        return j;
//    }

}
