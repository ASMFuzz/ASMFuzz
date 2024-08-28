import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyJVMTest_7438 {

    static String format = "n$^>Bmb^4v";

    static Object params = -1423573239;

    static Queue<String> records = new ConcurrentLinkedQueue<>();

    Object log(String format, Object... params) {
        records.add(String.format(format, params));
        return params;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7438().log(format, params);
    }
}
