import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MyJVMTest_12166 {

    int numClasses() {
        return classes.size();
    }

    int numInterfaces() {
        return interfaces.size();
    }

    static int maxId = 2;

    static HashSet<Integer> classes = null;

    static HashSet<Integer> interfaces = null;

    static HashMap<Integer, HashSet<Integer>> extensions = null;

    int numTypes() {
        return numClasses() + numInterfaces();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12166().numTypes());
    }
}
