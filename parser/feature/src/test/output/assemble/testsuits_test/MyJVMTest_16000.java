import java.util.function.*;

public class MyJVMTest_16000 {

    void m() {
        Function<String, String> f = BoundUnboundMethRefSearch::foo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16000().m();
    }
}
