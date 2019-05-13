import sort.*;
import util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        sortTest(new QuickSort());
        HashMap hashMap = new HashMap();
        ClassLoader classLoader = HashMap.class.getClassLoader();
        while (classLoader != null) {
            Log.d(classLoader.toString());
            classLoader = classLoader.getParent();
        }

    }

    private static void sortTest(ISort sort) {
        int[] data = {4,3,5,8,1,2,10,9,7,0,6};
        sort.sort(data);
    }

}
