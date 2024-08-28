import java.util.*;
import javax.crypto.*;
import java.security.*;

public class MyJVMTest_2918 {

    String getAlgorithm() {
        return "MyDestroyablePrivateKey algorithm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2918().getAlgorithm());
    }
}
