import java.io.IOException;

public class MyJVMTest_9836 {

    void doSomething() throws IOException {
        int r = System.in.read();
        System.out.println("read: " + r);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9836().doSomething();
    }
}
