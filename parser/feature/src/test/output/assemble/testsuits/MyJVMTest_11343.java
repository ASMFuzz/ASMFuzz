import java.io.IOException;

public class MyJVMTest_11343 {

    static byte[] data = {-113,45,83,-8,91,5,-5,-14,-50,-18};

    static int pos = 0;

    static boolean canMark = true;

    int read() throws IOException {
        if (pos >= data.length) {
            return -1;
        }
        return data[pos++] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11343().read());
    }
}
