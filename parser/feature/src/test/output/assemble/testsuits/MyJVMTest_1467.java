import java.io.IOException;

public class MyJVMTest_1467 {

    static byte[] data = {63,86,-67,86,-22,102,-97,85,-4,86};

    static int pos = 0;

    int read() throws IOException {
        if (pos >= data.length) {
            return -1;
        }
        return data[pos++] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1467().read());
    }
}
