import javax.management.*;
import java.io.IOException;

public class MyJVMTest_10012 {

    Object getIOException() throws IOException {
        throw new IOException("oops");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10012().getIOException());
    }
}
