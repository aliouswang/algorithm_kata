package queue;

/**
 * 有界队列，如果满了 put 阻塞，如果空了 take 阻塞
 *
 * @param <T>
 */
public interface IQueue<T> {

    boolean isEmpty();

    int size();

    void put(T t);

    T take();

}
