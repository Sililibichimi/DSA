package DSA.Hw7_22000123_NguyenDucSi.Baitap1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Test {



    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> arrayTree = new ArrayBinaryTree<>();
        arrayTree.setRoot(1);
        arrayTree.setLeft(1, 2);
        arrayTree.setRight(1, 3);
        arrayTree.setLeft(2, 4);
        arrayTree.setRight(2, 5);
        arrayTree.setLeft(3, 6);
        arrayTree.setRight(3, 7);

        LinkedBinaryTree<Integer, Integer> linkedTree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = linkedTree.addRoot(32);
        LinkedBinaryTree.Node<Integer> left = linkedTree.addLeft(root, 1);
        LinkedBinaryTree.Node<Integer> right = linkedTree.addRight(root, 32);
        linkedTree.addLeft(left, 1);
        linkedTree.addRight(left, 2);
        linkedTree.addLeft(right, 2);
        linkedTree.addRight(right, 5);

        try {
            File file = new File("G:\\Program_File\\java\\DSA\\Hw7_22000123_NguyenDucSi\\Baitap1\\output");
            FileWriter writer = new FileWriter(file, false);
            arrayTree.print(writer);
            linkedTree.print(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
