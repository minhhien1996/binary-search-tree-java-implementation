/**
 * Created by minhhien1996 on 6/11/17.
 */
public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void insert(Node newNode, Node root) {
        //the greater goes right, the less goes left
        if (newNode.getData().compareTo((T) root.getData()) > 0) {
            if (root.getRight() == null) {
                root.setRight(newNode);
            } else {
                insert(newNode, root.getRight());
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
            } else {
                insert(newNode, root.getLeft());
            }
        }
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            insert(newNode, this.root);
        }
    }
    Node remove(T data, Node<T> root)
    {
        if (root == null)  return root;

        if (data.compareTo(root.getData()) < 0)
            root.left = remove(data, root.left);
        else if (data.compareTo(root.getData()) > 0)
            root.right = remove(data, root.right);
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children
            root.setData((T) minValue(root.right));

            // Delete successor
            root.right = remove(root.getData(), root.right);
        }

        return root;
    }


    void removeX(T data) {}

    T minValue(Node<T> root)
    {
        T minv = root.getData();
        while (root.left != null)
        {
            minv = (T) root.left.getData();
            root = root.left;
        }
        return minv;
    }


    public void remove(T data) {
        if (root == null) return;
        remove(data, root);
    }

    public Node<T> search(T data, Node<T> root) {
        if (root == null) return null;

        if (data.compareTo(root.getData()) == 0) return root;

        if (data.compareTo(root.getData()) > 0)
            return search(data, root.getRight());
        else
            return search(data, root.getLeft());
    }

    public String print(Node<T> root) {
        if (root == null) return " ";
        return "( "
                + print(root.getLeft())
                + " "
                + root.getData()
                + " "
                + print(root.getRight())
                + " )";
    }

    public void print() {
        System.out.println(print(this.root));
    }

    @Override
    public String toString() {
        return "BinaryTree " + print(this.root);
    }

    public String printUsingStack() {
        Stack<Node> nodeStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        Node node = this.root;

        while (!nodeStack.isEmpty() || node != null) {
            if (node != null) {
                nodeStack.push(node);
                node = node.getLeft();
            } else {
                node = nodeStack.pop();

                stringBuilder.append(node.getData());
                stringBuilder.append(' ');

                node = node.getRight();
            }
        }

        return stringBuilder.toString();

    }
}
