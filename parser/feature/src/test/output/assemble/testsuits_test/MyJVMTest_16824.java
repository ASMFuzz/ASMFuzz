import java.io.File;
import java.util.concurrent.CountDownLatch;

public class MyJVMTest_16824 {

    String getDescription() {
        return "Text files";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16824().getDescription());
    }
}
