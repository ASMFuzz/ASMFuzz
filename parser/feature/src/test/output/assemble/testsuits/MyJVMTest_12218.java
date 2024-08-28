import java.util.*;
import javax.crypto.*;
import java.security.*;

public class MyJVMTest_12218 {

    String getAlgorithm() {
        return "MyDestroyablePrivateKey algorithm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12218().getAlgorithm());
    }
}
