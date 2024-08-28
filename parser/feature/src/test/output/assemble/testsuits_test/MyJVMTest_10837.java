import java.io.ByteArrayOutputStream;

public class MyJVMTest_10837 {

    Object initialSnapshot() {
        return "initial snapshot";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10837().initialSnapshot());
    }
}
