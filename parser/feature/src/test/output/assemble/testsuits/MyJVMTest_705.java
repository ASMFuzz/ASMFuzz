import java.io.*;
import java.util.*;

public class MyJVMTest_705 {

    static boolean flag = true;

    static boolean _bitWiseClassCompare = false;

    boolean setBitWiseClassCompare(boolean flag) {
        return _bitWiseClassCompare = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_705().setBitWiseClassCompare(flag));
    }
}
