import java.io.*;
import java.util.*;

public class MyJVMTest_9881 {

    static boolean flag = false;

    static boolean _bitWiseClassCompare = false;

    boolean setBitWiseClassCompare(boolean flag) {
        return _bitWiseClassCompare = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9881().setBitWiseClassCompare(flag));
    }
}
