import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class MyJVMTest_6331 {

    static char[] password = null;

    int getIterationCount() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6331().getIterationCount());
    }
}
