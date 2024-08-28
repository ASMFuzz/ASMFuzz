import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15703 {

    static int deflatedLength = 8;

    static int srcMode = 7, dstMode = 4;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15703().pass();
    }
}
