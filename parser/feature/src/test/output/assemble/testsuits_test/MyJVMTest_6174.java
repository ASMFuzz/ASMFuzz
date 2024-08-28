import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_6174 {

    <T, E extends List<T>> E typedNull() {
        return null;
    }

    void call() {
        ArrayList<String> list = typedNull();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6174().call();
    }
}
