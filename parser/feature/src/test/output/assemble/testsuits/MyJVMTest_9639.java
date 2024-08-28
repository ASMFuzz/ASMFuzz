import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_9639 {

    static int id = 1764661668;

    static int OBJECT_CLASS = -1;

    static int maxId = 9;

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
        System.out.println(new MyJVMTest_9639().isInterface(id));
    }
}
