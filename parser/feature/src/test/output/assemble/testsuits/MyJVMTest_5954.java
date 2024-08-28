import java.util.concurrent.*;
import java.util.function.*;

public class MyJVMTest_5954 {

    static Runnable action = () -> {
    };

    CompletableFuture<Void> ok(Runnable action) {
        return CompletableFuture.runAsync(action);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5954().ok(action));
    }
}
