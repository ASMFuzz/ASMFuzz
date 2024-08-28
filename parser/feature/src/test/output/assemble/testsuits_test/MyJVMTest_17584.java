import java.text.*;

public class MyJVMTest_17584 {

    static int h = 2;

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17584().heightToNodes(h));
    }
}
