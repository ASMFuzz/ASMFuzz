import java.lang.management.*;

public class MyJVMTest_8037 {

    long System_milliTime() {
        return System.nanoTime() / 1000000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8037().System_milliTime());
    }
}
