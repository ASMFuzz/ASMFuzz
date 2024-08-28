import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16468 {

    static int i1 = 3;

    static int i2 = 3;

    int assertEquals(int i1, int i2) {
        if (i1 != i2) {
            throw new RuntimeException("Test failed, " + i1 + " != " + i2);
        }
        return i2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16468().assertEquals(i1, i2);
    }
}
