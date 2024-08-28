import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_3525 {

    static int sub = 1556472070;

    static int sup = 0;

    static int maxId = 0;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    HashSet<Integer> addInherit(final int sub, final int sup) {
        HashSet<Integer> ext = extensions.get(sub);
        if (ext == null) {
            ext = new HashSet<>();
            extensions.put(sub, ext);
        }
        ext.add(sup);
        return ext;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3525().addInherit(sub, sup);
    }
}
