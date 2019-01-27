package day5b.file;

import day6a.TreeNode;

import java.io.File;

public class FileDisplay {
    public static void main(String[] args) {
        new FileDisplay().run();
    }

    private void run() {
        File file = new File("C:\\Users\\JerryZhang\\" +
                "OneDrive - Concordia University - Canada" +
                "\\ProgrammingProjects\\zz\\ENCS111\\ENCS111\\");
//        displayFile(file);


    }

    public void displayFile(File file){
        if (file.isDirectory()) {
            System.out.println(file);
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                displayFile(file1);
            } else {
                System.out.println(file1);
            }
        }
    }

    public void buildFileTree(File file, TreeNode treeNode){
        treeNode = new TreeNode(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                TreeNode node1 = new TreeNode(file1.getName());
                treeNode.addChild(node1);
                if (file1.isDirectory()) {
                    buildFileTree(file1,node1);
                }
            }
        }
    }
}
