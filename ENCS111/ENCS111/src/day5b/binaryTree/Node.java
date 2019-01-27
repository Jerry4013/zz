package day5b.binaryTree;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public void bindLeft(Node node){
        left = node;
        node.parent = this;
    }

    public void bindRight(Node node){
        right = node;
        node.parent = this;
    }

}
