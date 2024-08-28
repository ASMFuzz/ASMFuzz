import java.util.concurrent.Semaphore;

public class MyJVMTest_2912 {

    static Semaphore startSem = null;

    static Semaphore redefineSem = null;

    String meth2() {
        return "before";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2912().meth2());
    }
}
