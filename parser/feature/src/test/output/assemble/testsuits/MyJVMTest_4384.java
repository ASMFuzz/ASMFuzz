import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class MyJVMTest_4384 {

    Object run() {
        new File("abc").exists();
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4384().run());
    }
}
