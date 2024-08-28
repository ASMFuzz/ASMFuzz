import java.io.*;
import java.util.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.security.auth.callback.*;

public class MyJVMTest_9578 {

    Enumeration<String> engineAliases() {
        return new Vector<String>().elements();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9578().engineAliases());
    }
}
