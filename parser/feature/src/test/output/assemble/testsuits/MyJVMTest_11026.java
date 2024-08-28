import java.io.*;
import java.util.*;

public class MyJVMTest_11026 {

    static boolean flag = true;

    static boolean _ignoreCompileAttributes = false;

    boolean setIgnoreCompileAttributes(boolean flag) {
        return _ignoreCompileAttributes = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11026().setIgnoreCompileAttributes(flag));
    }
}
