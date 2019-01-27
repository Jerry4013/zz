package day5b.generalTree;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        new Driver().run();
    }

    private void run() {
        Node a = new Node("A");

        Node b = new Node("B");
        a.addChild(b);

        Node c = new Node("C");
        b.addChild(c);

        Node d = new Node("D");
        b.addChild(d);

        trace(a);
        levelPrint(a);
    }

    private void trace(Node node){
        System.out.println(node.getValue());

        List<Node> children = node.getChildren();
        for (Node child : children) {
            trace(child);
        }
    }

    private void levelPrint(Node node){
        levelPrint(node, 0);
    }

    private void levelPrint(Node node, int level){
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.println("+ " + node.getValue());

        List<Node> children = node.getChildren();
        for (Node child : children) {
            levelPrint(child, level + 1);
        }
    }


}
