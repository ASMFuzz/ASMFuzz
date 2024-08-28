import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_16075 {

    static int pos = 558245302;

    static Object x = 8;

    static List<Object> stack = new ArrayList<>();

    Object pushAt(int pos, Object x) {
        stack.add(stack.size() + pos, x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16075().pushAt(pos, x);
    }
}
