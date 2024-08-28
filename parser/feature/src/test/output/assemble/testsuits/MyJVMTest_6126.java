import javax.management.*;

public class MyJVMTest_6126 {

    static int count = 9;

    void postDeregister() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6126().postDeregister();
    }
}
