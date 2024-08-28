import java.io.FilterInputStream;
import java.io.IOException;

public class MyJVMTest_1003 {

    static int readLimit = 1;

    int mark(int readLimit) {
        throw new UnsupportedOperationException("mark");
        return readLimit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1003().mark(readLimit);
    }
}
