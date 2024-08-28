import java.text.*;

public class MyJVMTest_1560 {

    int height(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    int shortestPath(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + Math.min(shortestPath(t.left), shortestPath(t.right));
        }
    }

    static int treeHeight = 14;

    static TreeNode[] trees = {null,null,null,null,null,null,null,null,null,null};

    void checkTrees() {
        int ntrees = trees.length;
        for (int i = 0; i < ntrees; i++) {
            TreeNode t = trees[i];
            int h1 = height(t);
            int h2 = shortestPath(t);
            if ((h1 != treeHeight) || (h2 != treeHeight)) {
                System.err.println("*****BUG: " + h1 + " " + h2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1560().checkTrees();
    }
}
