import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_13861 {

    static int id = 2;

    static int OBJECT_CLASS = -1;

    static int maxId = -2091408724;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    boolean isClass(final int id) {
        if (id == OBJECT_CLASS) {
            return true;
        }
        return classes.contains(id);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13861().isClass(id));
    }
}
