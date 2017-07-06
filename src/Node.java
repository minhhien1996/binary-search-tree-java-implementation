import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by minhhien1996 on 6/11/17.
 */
public class Node <T extends Comparable<T>> {
    T data;

    Node left;

    Node right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int compareTo(Object o) {
         if (o instanceof Node) {
            return data.compareTo((T) ((Node) o).getData());
        }
        throw new TypeMismatchException("Can not compare Node to another type");
    }
}
