import java.io.*;

public class MyJVMTest_15483 {

    void checkPoint() throws IOException {
        throw new NumberFormatException("redefined");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15483().checkPoint();
    }
}
