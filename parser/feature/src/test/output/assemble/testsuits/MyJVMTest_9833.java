import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_9833 {

    int sp() {
        return stack.size();
    }

    static List<Object> stack = new ArrayList<>();

    Object pop() {
        return stack.remove(sp() - 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9833().pop());
    }
}
