package queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个基于数组的有界队列
 * @param <T>
 */
public class ArrayQueue<T> implements IQueue<T>{

    private static final int DEFAULT_SIZE = 16;

    private T[] datas;
    private int size;

    private ReentrantLock lock;

    private Condition notEmpty;
    private Condition notFull;

    private int putIndex, takeIndex;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int size) {
        this.datas = (T[]) new Object[size];
        this.size = 0;
        this.putIndex = 0;
        this.takeIndex = 0;

        lock = new ReentrantLock(false);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }


    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(T t) {
        lock.lock();
        try {
            while (size == datas.length) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            datas[putIndex++] = t;
            if (putIndex == datas.length) {
                putIndex = 0;
            }
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    @Override
    public T take() {
        lock.lock();
        while (size == 0) {
            try {
                notEmpty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T data = datas[takeIndex++];
        if (takeIndex == datas.length) {
            takeIndex = 0;
        }
        size--;
        notFull.signal();
        lock.unlock();
        return data;
    }
}
