import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_8661 {

    static int pos = 0;

    static Object x = 6;

    static List<Object> stack = new ArrayList<>();

    Object pushAt(int pos, Object x) {
        stack.add(stack.size() + pos, x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8661().pushAt(pos, x);
    }
}
