import java.util.*;
import javax.crypto.*;
import java.security.*;

public class MyJVMTest_12250 {

    String getFormat() {
        return "MyDestroyablePrivateKey format";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12250().getFormat());
    }
}
