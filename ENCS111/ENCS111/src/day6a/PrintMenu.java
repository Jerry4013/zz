package day6a;

import java.util.List;

public class PrintMenu {
    public static void main(String[] args) {
        TreeNode menu = new TreeNode("Menu");

        TreeNode file = new TreeNode("File");
        TreeNode edit = new TreeNode("Edit");
        TreeNode view = new TreeNode("view");

        menu.addChild(file);
        menu.addChild(edit);
        menu.addChild(view);

        TreeNode new_window = new TreeNode("New Window");
        TreeNode new_file = new TreeNode("New File");
        TreeNode open_recent = new TreeNode("Open Recent");
        TreeNode save = new TreeNode("Save");
        TreeNode save_as = new TreeNode("Save As");

        file.addChild(new_window);
        file.addChild(new_file);
        file.addChild(open_recent);
        file.addChild(save);
        file.addChild(save_as);

        TreeNode node201709 = new TreeNode("201709");
        TreeNode node201711 = new TreeNode("201711");
        TreeNode pdf = new TreeNode("PDF");
        TreeNode image = new TreeNode("Image");

        open_recent.addChild(node201709);
        open_recent.addChild(node201711);
        save_as.addChild(pdf);
        save_as.addChild(image);

        TreeNode add_node = new TreeNode("Add Node");
        TreeNode delete_node = new TreeNode("Delete Node");
        edit.addChild(add_node);
        edit.addChild(delete_node);

        TreeNode view_symbol = new TreeNode("View Symbol");
        TreeNode view_class = new TreeNode("View Class");
        TreeNode panels = new TreeNode("Panels");
        view.addChild(view_symbol);
        view.addChild(view_class);
        view.addChild(panels);

        TreeNode color = new TreeNode("Color");
        TreeNode picture = new TreeNode("Picture");
        panels.addChild(color);
        panels.addChild(picture);

        print(menu);
    }

    public static void print(TreeNode treeNode){
        TreeNode position = treeNode;
        String result = treeNode.getValue();
        if (treeNode.getLevel() > 0){
            result = "+\t" + result;
        }
        while (position.getParent() != null){
            if (!position.getParent().isLast()) {
                result = "|\t" + result;
            } else {
                result = "\t" + result;
            }
            position = position.getParent();
        }
        System.out.println(result);

        List<TreeNode> subNodes = treeNode.getChildren();
        if (subNodes != null) {
            for (TreeNode subNode : subNodes) {
                print(subNode);
            }
        }
    }

    private void trace(TreeNode node) {
        System.out.println(node.getValue());

        List<TreeNode> children = node.getChildren();
        for (TreeNode child : children) {
            trace(child);
        }
    }

    private void levelPrint(TreeNode node) {
        levelPrint(node, 0);
    }

    private void levelPrint(TreeNode node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }

        System.out.println("+\t" + node.getValue());

        List<TreeNode> children = node.getChildren();
        for (TreeNode child : children) {
            levelPrint(child, level + 1);
        }
    }
}
