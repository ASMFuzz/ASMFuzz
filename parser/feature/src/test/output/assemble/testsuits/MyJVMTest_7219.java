import java.util.concurrent.*;
import java.util.function.*;

public class MyJVMTest_7219 {

    static Supplier<T> action = null;

    <T> CompletableFuture<T> ok(Supplier<T> action) {
        return CompletableFuture.supplyAsync(action);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7219().ok(action));
    }
}
