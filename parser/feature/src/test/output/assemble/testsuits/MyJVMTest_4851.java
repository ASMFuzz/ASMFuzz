import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_4851 {

    static int q = 0;

    static int i = 3;

    static int r = 0, c = -629513284, f = -1859411854, t = -762955085;

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
        new MyJVMTest_4851().addToM(q, i);
    }
}
