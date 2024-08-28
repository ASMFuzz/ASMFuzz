import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_8855 {

    static Object x = 0;

    static List<Object> stack = new ArrayList<>();

    Object push(Object x) {
        stack.add(x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8855().push(x);
    }
}
