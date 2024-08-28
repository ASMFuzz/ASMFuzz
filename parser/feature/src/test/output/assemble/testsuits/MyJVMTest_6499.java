import sun.management.*;

public class MyJVMTest_6499 {

    static int i = 0;

    void method1() {
        i = 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6499().method1();
    }
}
