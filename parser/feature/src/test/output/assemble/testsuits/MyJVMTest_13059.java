import java.util.concurrent.TimeUnit;

public class MyJVMTest_13059 {

    static TimeUnit unit = null;

    String getMessage() {
        return "Failed in " + unit.toNanos(1) + " ns";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13059().getMessage());
    }
}
