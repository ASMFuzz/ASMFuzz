import java.util.function.Supplier;

public class MyJVMTest_9138 {

    static Supplier<String> supplier = null;

    static String msg = "f(|QMK`d2D";

    Supplier<String> test(Supplier<String> supplier) {
        msg = supplier.get();
        return supplier;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9138().test(supplier);
    }
}
