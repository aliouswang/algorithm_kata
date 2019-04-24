package spring_2;

public interface IStack<T> {

    int size();
    boolean isEmpty();
    void push(T t);
    T pop();

}
