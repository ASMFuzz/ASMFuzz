import java.lang.reflect.Method;

public class MyJVMTest_15625 {

    void run() {
        throw new AbstractMethodError("Not really, just testing");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15625().run();
    }
}
