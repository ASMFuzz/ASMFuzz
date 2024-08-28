import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_18008 {

    static int maxId = 5;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    int addClass() {
        final int id = maxId++;
        classes.add(id);
        return id;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18008().addClass());
    }
}
