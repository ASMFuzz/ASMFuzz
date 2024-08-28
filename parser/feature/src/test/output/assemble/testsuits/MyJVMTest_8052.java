import java.io.*;
import java.util.*;

public class MyJVMTest_8052 {

    static boolean flag = true;

    static boolean _validateClass = true;

    boolean setValidateClass(boolean flag) {
        return _validateClass = flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8052().setValidateClass(flag));
    }
}
