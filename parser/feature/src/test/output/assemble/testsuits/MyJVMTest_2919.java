import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_2919 {

    static String csn = "+d\"%r4-@*J";

    static boolean testRegistered = false;

    String check(String csn, boolean testRegistered) throws Exception {
        if (!Charset.forName(csn).isRegistered() && testRegistered)
            throw new Exception("Not registered: " + csn);
        else if (Charset.forName(csn).isRegistered() && !testRegistered)
            throw new Exception("Registered: " + csn + "should be unregistered");
        return csn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2919().check(csn, testRegistered);
    }
}
