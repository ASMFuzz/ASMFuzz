import java.lang.management.*;

public class MyJVMTest_11194 {

    void doit() {
        String tmp = "";
        long hashCode = 0;
        for (int counter = 0; counter < 1000; counter++) {
            tmp += counter;
            hashCode = tmp.hashCode();
        }
        System.out.println(Thread.currentThread().getName() + " hashcode: " + hashCode);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11194().doit();
    }
}
