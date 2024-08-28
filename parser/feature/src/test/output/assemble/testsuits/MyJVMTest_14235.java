import javax.management.*;

public class MyJVMTest_14235 {

    static int count = 6;

    void preDeregister() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14235().preDeregister();
    }
}
