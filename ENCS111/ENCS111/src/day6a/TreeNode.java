package day6a;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private String value;
    private TreeNode parent;
    private int level;
    private int position;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    private List<TreeNode> subnodes = new ArrayList<>();

    public void addChild(TreeNode node){
        node.position = subnodes.size()+1;
        subnodes.add(node);
        node.parent = this;
        node.level = this.level + 1;
    }
    public List<TreeNode> getChildren(){
        return subnodes;
    }

    public boolean isLast(){
        if (getParent() == null) {
            return true;
        }
        return position == getParent().getChildren().size();
    }

}
