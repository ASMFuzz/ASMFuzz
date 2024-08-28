import java.lang.invoke.*;

public class MyJVMTest_9625 {

    static int x = 6;

    String i2h(int x) {
        return Integer.toHexString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9625().i2h(x));
    }
}
