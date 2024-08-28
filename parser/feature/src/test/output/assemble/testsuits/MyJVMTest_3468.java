import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_3468 {

    static Object x = 5;

    static List<Object> stack = new ArrayList<>();

    Object push(Object x) {
        stack.add(x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3468().push(x);
    }
}
