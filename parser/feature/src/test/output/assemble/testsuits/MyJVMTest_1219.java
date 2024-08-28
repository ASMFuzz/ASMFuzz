import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_1219 {

    static boolean unreferenced = false;

    void unreferenced() {
        synchronized (this) {
            unreferenced = true;
            notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1219().unreferenced();
    }
}
