import java.lang.invoke.*;

public class MyJVMTest_465 {

    static int x = 0;

    String i2h(int x) {
        return Integer.toHexString(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_465().i2h(x));
    }
}
