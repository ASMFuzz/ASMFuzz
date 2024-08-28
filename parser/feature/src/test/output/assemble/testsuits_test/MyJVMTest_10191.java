import java.io.FilterInputStream;
import java.io.IOException;

public class MyJVMTest_10191 {

    static int readLimit = -1542334844;

    int mark(int readLimit) {
        throw new UnsupportedOperationException("mark");
        return readLimit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10191().mark(readLimit);
    }
}
