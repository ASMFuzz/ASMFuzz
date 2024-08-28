import java.lang.instrument.*;
import java.net.*;
import java.io.*;
import java.security.*;

public class MyJVMTest_15334 {

    static URL sURL = null;

    static ClassLoader sClassLoader = null;

    void generateNewClassLoader() {
        sClassLoader = new URLClassLoader(new URL[] { sURL });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15334().generateNewClassLoader();
    }
}
