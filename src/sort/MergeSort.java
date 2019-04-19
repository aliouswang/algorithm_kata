package sort;

import util.PrintUtil;

/**
 * 归并排序 时间复杂度 O(NlgN), 是稳定的排序，但是需要额外的空间来辅助合并，
 * 空间复杂度是 O(N)， 但是 会涉及多次 空间的 申请和释放，这是 比较致命的缺点。
 * 但是 分治的思想，需要掌握并能熟练应用
 *
 *
 */
public class MergeSort implements ISort{

    @Override
    public void sort(int[] data) {
        PrintUtil.log("before merge sort:", data);
        sort(data, 0, data.length - 1);
        PrintUtil.log("before merge sort:", data);
    }

    private void sort(int[] data, int l, int h) {
        if (l >= h) return;
        int m = l + (h - l) / 2;
        sort(data, l, m);
        sort(data, m + 1, h);
        int i = l;
        int j = m+1;
        int k = 0;
        int[] temp = new int[h - l + 1];
        while (i <= m || j <= h) {
            if (i > m) {
                temp[k++] = data[j++];
            }else if (j > h) {
                temp[k++] = data[i++];
            } else if (data[i] > data[j]) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }
        System.arraycopy(temp, 0, data, l, temp.length);
    }

}
