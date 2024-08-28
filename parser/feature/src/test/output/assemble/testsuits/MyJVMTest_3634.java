import java.util.concurrent.*;
import java.util.function.*;

public class MyJVMTest_3634 {

    static T body = null;

    <T> CompletableFuture<T> ok(T body) {
        return CompletableFuture.completedFuture(body);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3634().ok(body));
    }
}
