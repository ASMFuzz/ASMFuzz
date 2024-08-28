import java.util.concurrent.*;
import java.util.function.*;

public class MyJVMTest_16742 {

    static Supplier<T> action = null;

    <T> CompletableFuture<T> ok(Supplier<T> action) {
        return CompletableFuture.supplyAsync(action);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16742().ok(action));
    }
}
