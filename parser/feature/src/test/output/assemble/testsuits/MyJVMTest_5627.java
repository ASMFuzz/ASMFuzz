import java.io.*;
import java.util.*;

public class MyJVMTest_5627 {

    static boolean flag = false;

    static boolean _ignoreDebugAttributes = false;

    boolean setIgnoreDebugAttributes(boolean flag) {
        return _ignoreDebugAttributes = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5627().setIgnoreDebugAttributes(flag));
    }
}
