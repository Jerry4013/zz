package day5b.binaryTree;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    static void add(BinaryTree tree, int value){
        if (tree.root == null){
            tree.root = new Node(value);
            return;
        }
        if (value < tree.root.getValue()) {
            if (tree.root.getLeft() == null){
                tree.root.bindLeft(new Node(value));
                return;
            }
            BinaryTree leftSubTree = new BinaryTree(tree.root.getLeft());
            add(leftSubTree, value);
        } else {
            if (tree.root.getRight() == null) {
                tree.root.bindRight(new Node(value));
                return;
            }
            BinaryTree rightSubTree = new BinaryTree(tree.root.getRight());
            add(rightSubTree, value);
        }
    }

    public static void main(String[] args) {
        new BinaryTree().run();
    }

    private void run() {
        BinaryTree tree = new BinaryTree();

        add(tree, 6);
        add(tree, 7);
        add(tree, 3);
        add(tree, 8);
        add(tree, 4);

        levelPrint(tree.root, 0);

        System.out.println(exist(tree, 2));
        System.out.println(exist(tree, 6));
        System.out.println(exist(tree, 4));
    }

    private void trace(Node node) {
        System.out.println(node.getValue());
        trace(node.getLeft());
        trace(node.getRight());
    }

    private void levelPrint(Node node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println("+\t" + node.getValue());
        levelPrint(node.getLeft(), level + 1);
        levelPrint(node.getRight(), level + 1);
    }

    static boolean exist(BinaryTree tree, int value){
        if (tree.root == null) {
            return false;
        }
        if (value == tree.root.getValue()) {
            return true;
        }
        if (value < tree.root.getValue()) {
            BinaryTree left = new BinaryTree(tree.root.getLeft());
            return exist(left, value);
        } else {
            BinaryTree right = new BinaryTree(tree.root.getRight());
            return exist(right, value);
        }
    }
}
