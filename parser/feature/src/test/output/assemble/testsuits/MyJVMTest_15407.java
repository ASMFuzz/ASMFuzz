import java.util.concurrent.*;
import java.util.function.*;

public class MyJVMTest_15407 {

    static Runnable action = () -> {
    };

    CompletableFuture<Void> ok(Runnable action) {
        return CompletableFuture.runAsync(action);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15407().ok(action));
    }
}
