import java.io.*;

public class MyJVMTest_16083 {

    static boolean cond = true;

    static int assertionCount = 0;

    static LSI cisi = null;

    static LSI iisi = null;

    boolean assertTrue(boolean cond) {
        assertionCount++;
        if (!cond)
            throw new AssertionError();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16083().assertTrue(cond);
    }
}
