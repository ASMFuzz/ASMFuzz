import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_17083 {

    static int maxId = 0;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    int addInterface() {
        final int id = maxId++;
        interfaces.add(id);
        return id;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17083().addInterface());
    }
}
