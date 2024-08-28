import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_6579 {

    static int pos = -1030330830;

    static Object x = 7;

    static List<Object> stack = new ArrayList<>();

    Object pushAt(int pos, Object x) {
        stack.add(stack.size() + pos, x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6579().pushAt(pos, x);
    }
}
