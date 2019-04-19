package sort;

import util.PrintUtil;

public class InsertSort implements ISort{

    @Override
    public void sort(int[] data) {
        PrintUtil.log("before insert sort:", data);
        if (data == null || data.length <= 1) return;
        int len = data.length;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int cur = data[i];
            for (;j >= 0; j--) {
                if (cur < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = cur;
        }
        PrintUtil.log("before insert sort:", data);
    }

}
