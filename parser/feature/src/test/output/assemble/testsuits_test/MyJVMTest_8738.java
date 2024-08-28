import java.io.*;
import java.util.*;

public class MyJVMTest_8738 {

    static String l1 = "$~=L>(plgg";

    static int i1 = 6;

    static String l2 = "%NJ3Dt59E3";

    static int i2 = 8;

    int checkEqual(String l1, int i1, String l2, int i2) throws Exception {
        if (i1 != i2)
            throw new Exception(l1 + " warn count, " + i1 + ", does not match " + l2 + " warn count, " + i2);
        return i2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8738().checkEqual(l1, i1, l2, i2);
    }
}
