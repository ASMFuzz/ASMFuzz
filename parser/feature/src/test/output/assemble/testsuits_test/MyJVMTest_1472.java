import java.io.*;
import java.util.*;

public class MyJVMTest_1472 {

    static boolean flag = false;

    static boolean _ignoreUnknownAttributes = false;

    boolean setIgnoreUnknownAttributes(boolean flag) {
        return _ignoreUnknownAttributes = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1472().setIgnoreUnknownAttributes(flag));
    }
}
