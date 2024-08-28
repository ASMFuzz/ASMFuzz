import java.awt.Frame;
import java.awt.Component;

public class MyJVMTest_9535 {

    static int n = 0;

    int sign(int n) {
        return n < 0 ? -1 : n == 0 ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9535().sign(n));
    }
}
