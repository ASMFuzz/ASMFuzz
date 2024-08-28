import java.util.*;
import javax.crypto.*;
import java.security.*;

public class MyJVMTest_5641 {

    String getAlgorithm() {
        return "MyDestroyableSecretKey algorithm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5641().getAlgorithm());
    }
}
