import java.io.IOException;

public class MyJVMTest_665 {

    void doSomething() throws IOException {
        int r = System.in.read();
        System.out.println("read: " + r);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_665().doSomething();
    }
}
