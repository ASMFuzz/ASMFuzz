import java.io.InputStream;

public class MyJVMTest_3120 {

    boolean isReadOnly() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3120().isReadOnly());
    }
}
