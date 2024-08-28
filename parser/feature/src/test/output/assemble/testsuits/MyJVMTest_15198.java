import java.net.*;
import java.io.*;

public class MyJVMTest_15198 {

    static Socket client = null, server = null;

    void usage() {
        System.out.println("   usage: java UrgentDataTest <runs client and server together>");
        System.out.println("   usage: java UrgentDataTest -server <runs server alone>");
        System.out.println("   usage: java UrgentDataTest -client host port <runs client and connects to" + " specified server>");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15198().usage();
    }
}
