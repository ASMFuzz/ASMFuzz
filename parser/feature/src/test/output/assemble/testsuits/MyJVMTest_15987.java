import sun.management.*;

public class MyJVMTest_15987 {

    static int i = 0;

    void method1() {
        i = 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15987().method1();
    }
}
