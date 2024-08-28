import java.io.IOException;

public class MyJVMTest_2097 {

    static byte[] data = {64,4,-127,-8,81,127,-81,18,-25,-6};

    static int pos = 0;

    static boolean canMark = true;

    int read() throws IOException {
        if (pos >= data.length) {
            return -1;
        }
        return data[pos++] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2097().read());
    }
}
