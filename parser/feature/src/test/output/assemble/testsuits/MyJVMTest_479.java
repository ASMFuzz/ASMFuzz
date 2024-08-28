import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_479 {

    static int id = 0;

    static int OBJECT_CLASS = -1;

    static int maxId = -2131408530;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    boolean isInterface(final int id) {
        if (id == OBJECT_CLASS) {
            return false;
        }
        return interfaces.contains(id);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_479().isInterface(id));
    }
}
