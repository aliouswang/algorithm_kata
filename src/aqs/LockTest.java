package aqs;

import util.Log;

public class LockTest {

    private static int count = 0;
    public static void main(String[] args) {
        SingleLock singleLock = new SingleLock();
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        singleLock.lock();
                        count++;
                        singleLock.unlock();
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            threads[0].join();
            threads[1].join();
            threads[2].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("total count:" + count);
    }

}
