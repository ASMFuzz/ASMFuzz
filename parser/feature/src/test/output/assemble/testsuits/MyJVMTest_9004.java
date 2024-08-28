import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_9004 {

    static int argsize = 80178350;

    int sp() {
        return stack.size();
    }

    static List<Object> stack = new ArrayList<>();

    List<Object> args(int argsize) {
        return stack.subList(sp() - argsize, sp());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9004().args(argsize));
    }
}
