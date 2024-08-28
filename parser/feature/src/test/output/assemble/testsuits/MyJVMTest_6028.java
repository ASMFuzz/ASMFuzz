import java.io.*;

public class MyJVMTest_6028 {

    void checkPoint() throws IOException {
        throw new NumberFormatException("redefined");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6028().checkPoint();
    }
}
