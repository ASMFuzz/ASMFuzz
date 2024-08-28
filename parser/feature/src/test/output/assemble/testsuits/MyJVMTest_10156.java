import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class MyJVMTest_10156 {

    Object run() {
        return System.getProperty("user.home");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10156().run());
    }
}
