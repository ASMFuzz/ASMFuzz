import java.io.*;
import java.util.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.security.auth.callback.*;

public class MyJVMTest_14342 {

    int engineSize() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14342().engineSize());
    }
}
