import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_4696 {

    static int maxId = 5;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    int numClasses() {
        return classes.size();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4696().numClasses());
    }
}
