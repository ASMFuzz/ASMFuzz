import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_6230 {

    static int deflatedLength = 0;

    static int srcMode = 9, dstMode = 0;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6230().pass();
    }
}
