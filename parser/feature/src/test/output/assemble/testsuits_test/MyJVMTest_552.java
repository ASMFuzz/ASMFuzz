import java.security.*;
import javax.crypto.*;

public class MyJVMTest_552 {

    String getAlgorithm() {
        return "DES";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_552().getAlgorithm());
    }
}
