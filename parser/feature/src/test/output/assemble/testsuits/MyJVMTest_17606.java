import java.lang.management.*;

public class MyJVMTest_17606 {

    long System_milliTime() {
        return System.nanoTime() / 1000000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17606().System_milliTime());
    }
}
