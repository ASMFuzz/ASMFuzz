import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_14251 {

    static int q = 3;

    static int i = 0;

    static int r = 0, c = -205415371, f = 4, t = 0;

    static Map<Integer, Integer> M = new HashMap<Integer, Integer>();

    int addToM(int q, int i) {
        Integer original = M.get(q);
        if (original == null)
            M.put(q, i);
        else
            M.put(q, Math.min(original, i));
        return q;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14251().addToM(q, i);
    }
}
