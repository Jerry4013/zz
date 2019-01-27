package day5b.generalTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private  String value;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private Node parent;

    private List<Node> nodes = new ArrayList<Node>();

    public void addChild(Node node){
        nodes.add(node);
        node.parent = this;
    }

    public List<Node> getChildren(){
        return nodes;
    }
}
