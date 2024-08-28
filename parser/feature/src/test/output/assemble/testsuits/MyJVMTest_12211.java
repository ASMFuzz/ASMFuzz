import java.util.concurrent.Semaphore;

public class MyJVMTest_12211 {

    static Semaphore startSem = null;

    static Semaphore redefineSem = null;

    String meth2() {
        return "before";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12211().meth2());
    }
}
