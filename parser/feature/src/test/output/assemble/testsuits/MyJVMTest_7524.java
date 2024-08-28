import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_7524 {

    <T, E extends List<T>> E typedNull() {
        return null;
    }

    static I i = typedNull();

    void call() {
        ArrayList<String> list = typedNull();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7524().call();
    }
}
