import java.util.*;
import javax.crypto.*;
import java.security.*;

public class MyJVMTest_14179 {

    String getFormat() {
        return "MyDestroyableSecretKey format";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14179().getFormat());
    }
}
