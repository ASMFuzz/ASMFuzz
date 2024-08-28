import java.lang.reflect.Method;

public class MyJVMTest_6155 {

    void run() {
        throw new AbstractMethodError("Not really, just testing");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6155().run();
    }
}
