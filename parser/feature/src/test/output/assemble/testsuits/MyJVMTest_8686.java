import java.awt.Frame;
import java.awt.Component;

public class MyJVMTest_8686 {

    static int n = 373104192;

    int sign(int n) {
        return n < 0 ? -1 : n == 0 ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8686().sign(n));
    }
}
