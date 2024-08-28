import java.io.InputStream;

public class MyJVMTest_12434 {

    boolean isReadOnly() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12434().isReadOnly());
    }
}
