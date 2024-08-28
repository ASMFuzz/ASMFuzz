import java.util.function.*;

public class MyJVMTest_6510 {

    void m() {
        Function<String, String> f = BoundUnboundMethRefSearch::foo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6510().m();
    }
}
