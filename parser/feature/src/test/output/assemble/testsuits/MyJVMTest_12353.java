import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_12353 {

    static String name = "&1Wbk~EEu%";

    static byte[] data = {-46,59,30,-120,-57,116,100,2,111,46};

    static int level = 0;

    static int STRIDE = 1024;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12353().pass();
    }
}
