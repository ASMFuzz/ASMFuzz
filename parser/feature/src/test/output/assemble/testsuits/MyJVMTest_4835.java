import javax.management.*;

public class MyJVMTest_4835 {

    static int count = 0;

    void preDeregister() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4835().preDeregister();
    }
}
