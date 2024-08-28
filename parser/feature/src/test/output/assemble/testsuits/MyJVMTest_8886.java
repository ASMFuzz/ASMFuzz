import sun.management.*;

public class MyJVMTest_8886 {

    static int i = 0;

    void method1() {
        i = 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8886().method1();
    }
}
