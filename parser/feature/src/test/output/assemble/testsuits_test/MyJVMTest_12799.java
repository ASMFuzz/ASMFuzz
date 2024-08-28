import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_12799 {

    static Object x = -2035356824;

    static List<Object> stack = new ArrayList<>();

    Object push(Object x) {
        stack.add(x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12799().push(x);
    }
}
