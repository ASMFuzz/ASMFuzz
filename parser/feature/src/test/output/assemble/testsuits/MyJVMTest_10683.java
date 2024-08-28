import java.io.IOException;

public class MyJVMTest_10683 {

    static byte[] data = {-70,51,-128,-128,-2,-9,58,-1,76,57};

    static int pos = 0;

    int read() throws IOException {
        if (pos >= data.length) {
            return -1;
        }
        return data[pos++] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10683().read());
    }
}
