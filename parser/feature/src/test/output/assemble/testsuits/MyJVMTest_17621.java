import java.io.*;
import java.util.*;

public class MyJVMTest_17621 {

    static boolean flag = false;

    static boolean _validateClass = true;

    boolean setValidateClass(boolean flag) {
        return _validateClass = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17621().setValidateClass(flag));
    }
}
