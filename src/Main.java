/**
 * Created by minhhien1996 on 6/12/17.
 */
public class Main {
    public static void main(String args[]) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.insert(10);
        integerBinaryTree.insert(5);
        integerBinaryTree.insert(12);
        integerBinaryTree.insert(7);
        integerBinaryTree.insert(8);

        System.out.println(integerBinaryTree);

        System.out.println(integerBinaryTree.printUsingStack());


    }
}
