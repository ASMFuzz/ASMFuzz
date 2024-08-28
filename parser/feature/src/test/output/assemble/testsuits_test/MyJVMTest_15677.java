import java.util.concurrent.*;

public class MyJVMTest_15677 {

    Object call() {
        throw new RuntimeException("should never reach here");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15677().call());
    }
}
