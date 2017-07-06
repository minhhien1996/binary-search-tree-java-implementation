import java.util.ArrayList;

/**
 * Created by minhhien1996 on 7/5/17.
 */
public class Stack<T> {
    public static final int CAPACITY = 100;
    ArrayList<T> list = new ArrayList<>(CAPACITY);

    int size = 0;
    public void push(T value) {
        list.add(size, value);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        return list.get(size - 1);
    }

    public T pop() {
        T top = list.get(size - 1);
        size--;
        return top;
    }

}
