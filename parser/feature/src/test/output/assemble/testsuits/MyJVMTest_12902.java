import java.io.IOException;
import java.io.InputStream;

public class MyJVMTest_12902 {

    boolean supportsCrossJoin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12902().supportsCrossJoin());
    }
}
