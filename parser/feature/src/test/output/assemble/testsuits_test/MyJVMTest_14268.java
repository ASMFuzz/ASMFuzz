import java.util.function.Supplier;

public class MyJVMTest_14268 {

    void unused() {
        Supplier<Local> s = () -> new Local();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14268().unused();
    }
}
