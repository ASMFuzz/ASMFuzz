import java.text.*;

public class MyJVMTest_13140 {

    static TreeNode full = null;

    static TreeNode partial = null;

    void replaceTreeWork(TreeNode full, TreeNode partial, boolean dir) {
        boolean canGoLeft = full.left != null && full.left.val > partial.val;
        boolean canGoRight = full.right != null && full.right.val > partial.val;
        if (canGoLeft && canGoRight) {
            if (dir)
                replaceTreeWork(full.left, partial, !dir);
            else
                replaceTreeWork(full.right, partial, !dir);
        } else if (!canGoLeft && !canGoRight) {
            if (dir)
                full.left = partial;
            else
                full.right = partial;
        } else if (!canGoLeft) {
            full.left = partial;
        } else {
            full.right = partial;
        }
    }

    static long actuallyMut = 0;

    TreeNode replaceTree(TreeNode full, TreeNode partial) {
        boolean dir = (partial.val % 2) == 0;
        actuallyMut++;
        replaceTreeWork(full, partial, dir);
        return partial;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13140().replaceTree(full, partial);
    }
}
