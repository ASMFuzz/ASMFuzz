import java.io.*;

public class MyJVMTest_2773 {

    static int count = 0;

    static byte[] orig = {-58,-37,105,-116,123,42,110,90,85,-20};

    static byte[] sdeAttr = {-12,100,-55,57,-96,-31,-47,57,-35,-120};

    static byte[] gen = {-116,47,-114,-75,91,-120,-71,-39,-111,-70};

    static int origPos = 0;

    static int genPos = 0;

    int copy(int count) {
        for (int i = 0; i < count; ++i) {
            gen[genPos++] = orig[origPos++];
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2773().copy(count);
    }
}
