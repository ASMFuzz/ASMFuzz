import java.security.*;
import javax.crypto.*;

public class MyJVMTest_819 {

    String getAlgorithm() {
        return "FOO";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_819().getAlgorithm());
    }
}
