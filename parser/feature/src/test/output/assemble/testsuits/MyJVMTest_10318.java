import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_10318 {

    int sp() {
        return stack.size();
    }

    static List<Object> stack = new ArrayList<>();

    Object top() {
        return stack.get(sp() - 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10318().top());
    }
}
