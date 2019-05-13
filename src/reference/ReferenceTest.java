package reference;

import util.Log;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.PriorityQueue;

public class ReferenceTest {

    public static void main(String[] args) throws InterruptedException {

        Thread workThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = new String("Java");
                String version = new String("1.9");

                ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
                WeakReference<String> reference = new WeakReference<String >(name, referenceQueue);

                SoftReference<String> softReference = new SoftReference<>(version, referenceQueue);

                Log.d("reference point:" + reference);

                name = null;
                version = null;

                System.gc();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("reference :" + reference.get());
                Log.d("softreference :" + softReference.get());
                Log.d("queue poll:" + referenceQueue.poll());

                PriorityQueue<String> priorityQueue;

                ClassLoader classLoader;

            }
        });

        workThread.start();

        workThread.join();


    }

}
