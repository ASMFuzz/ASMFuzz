import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyJVMTest_16972 {

    static String format = "Pz\"?\\x]^?s";

    static Object params = -895049947;

    static Queue<String> records = new ConcurrentLinkedQueue<>();

    Object log(String format, Object... params) {
        records.add(String.format(format, params));
        return params;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16972().log(format, params);
    }
}
