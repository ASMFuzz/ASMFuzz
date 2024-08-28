import java.io.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_16434 {

    static int i = 5;

    static StringBuffer strBuf = null;

    static int iter = 5;

    int hotMethod(int i) {
        strBuf.append(Integer.toString(i) + " ");
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16434().hotMethod(i);
    }
}
