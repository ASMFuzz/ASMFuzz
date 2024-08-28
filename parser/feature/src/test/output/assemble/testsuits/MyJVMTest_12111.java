import java.text.*;

public class MyJVMTest_12111 {

    static int h = 5;

    long heightToNodes(int h) {
        if (h == 0) {
            return 0;
        } else {
            long n = 1;
            while (h > 1) {
                n = n + n;
                h = h - 1;
            }
            return n + n - 1;
        }
    }

    static int BYTES_PER_NODE = 20;

    long heightToBytes(int h) {
        return BYTES_PER_NODE * heightToNodes(h);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12111().heightToBytes(h));
    }
}
