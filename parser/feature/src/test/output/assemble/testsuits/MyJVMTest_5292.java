import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class MyJVMTest_5292 {

    Object run() {
        return System.getProperty("java.version");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5292().run());
    }
}
