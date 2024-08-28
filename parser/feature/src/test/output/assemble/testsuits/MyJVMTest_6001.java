import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_6001 {

    static boolean isDestroyed = false;

    void useKey() {
        if (isDestroyed) {
            throw new IllegalStateException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6001().useKey();
    }
}
