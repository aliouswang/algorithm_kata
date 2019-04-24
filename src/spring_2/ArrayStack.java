package spring_2;

public class ArrayStack<T> implements IStack<T>{

    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private T[] datas;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.datas = (T[]) new Object[capacity];
        this.size = 0;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public void push(T t) {
        checkCapacity();
        this.datas[size++] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T object = this.datas[--size];
            this.datas[size] = null;
            return object;
        }
    }

    private void checkCapacity() {
        if (this.size == this.datas.length) {
            // we need to grow
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(this.datas, 0, newArray, 0, this.size);
            this.datas = newArray;
        }
    }
}
