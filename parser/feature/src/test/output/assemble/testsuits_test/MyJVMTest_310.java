import java.lang.management.*;

public class MyJVMTest_310 {

    void doit() {
        double sum = 0;
        for (int i = 0; i < 5000; i++) {
            double r = Math.random();
            double x = Math.pow(3, r);
            sum += x - r;
        }
        System.out.println(Thread.currentThread().getName() + " sum = " + sum);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_310().doit();
    }
}
