import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_9020 {

    static List<Object> stack = new ArrayList<>();

    int sp() {
        return stack.size();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9020().sp());
    }
}
