import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.rmi.server.*;
import java.util.*;
import javax.management.*;
import javax.management.remote.*;
import javax.management.remote.rmi.*;

public class MyJVMTest_14640 {

    int getLocalPort() {
        return ss.getLocalPort();
    }

    static ServerSocket ss = null;

    JMXServiceURL getAddress() throws Exception {
        System.out.println("SCSIH.getAddress()");
        return new JMXServiceURL("jmxmp", null, ss.getLocalPort());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14640().getAddress());
    }
}
