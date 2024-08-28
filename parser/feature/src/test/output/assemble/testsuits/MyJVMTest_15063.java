import java.io.*;
import java.util.*;

public class MyJVMTest_15063 {

    static boolean flag = true;

    static boolean _ignoreDebugAttributes = false;

    boolean setIgnoreDebugAttributes(boolean flag) {
        return _ignoreDebugAttributes = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15063().setIgnoreDebugAttributes(flag));
    }
}
