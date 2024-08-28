import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_15647 {

    <T, E extends List<T>> E typedNull() {
        return null;
    }

    void call() {
        ArrayList<String> list = typedNull();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15647().call();
    }
}
