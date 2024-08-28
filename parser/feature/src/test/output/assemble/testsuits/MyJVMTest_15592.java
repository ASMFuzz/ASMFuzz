import javax.management.*;

public class MyJVMTest_15592 {

    static int count = 382052664;

    void postDeregister() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15592().postDeregister();
    }
}
