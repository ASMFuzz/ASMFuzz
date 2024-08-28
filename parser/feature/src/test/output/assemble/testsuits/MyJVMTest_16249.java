import java.io.Reader;

public class MyJVMTest_16249 {

    static String key = "j1j&/i$1wm";

    Object get(String key) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16249().get(key));
    }
}
