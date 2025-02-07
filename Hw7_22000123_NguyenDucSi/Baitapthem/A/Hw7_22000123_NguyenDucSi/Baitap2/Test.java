package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitap2;

public class Test {

    public static void main(String[] args) {
        ExpressionTree<String> tree = new ExpressionTree<>();

        tree.addRoot("*");
        tree.addLeft(tree.getRoot(), "/");
        tree.addRight(tree.getRoot(), "-");

        tree.addLeft(tree.getLeft(tree.getRoot()), "18");
        tree.addRight(tree.getLeft(tree.getRoot()), "6");
        tree.addLeft(tree.getRight(tree.getRoot()), "3");
        tree.addRight(tree.getRight(tree.getRoot()), "2");

        System.out.print("Biểu thức theo dạng tiền tố:");
        tree.preoderPrint(tree.getRoot());
        System.out.println();

        System.out.print("Biểu thức theo dạng trung tố:");
        tree.postorderPrint(tree.getRoot());
        System.out.println();

        System.out.print("Biểu thức theo dạng hậu tố:");
        tree.inorderPrint(tree.getRoot());
        System.out.println( );

        double result = tree.evaluate(tree.getRoot());
        System.out.println("Giá trị của biểu thức: " + result);
    }

}
