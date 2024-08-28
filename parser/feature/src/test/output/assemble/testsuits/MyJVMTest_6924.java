import java.io.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_6924 {

    static int i = 9;

    static StringBuffer strBuf = null;

    static int iter = 5;

    int hotMethod(int i) {
        strBuf.append(Integer.toString(i) + " ");
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6924().hotMethod(i);
    }
}
