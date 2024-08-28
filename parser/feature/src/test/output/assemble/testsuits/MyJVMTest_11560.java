import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.rmi.server.*;
import java.util.*;
import javax.management.*;
import javax.management.remote.*;
import javax.management.remote.rmi.*;

public class MyJVMTest_11560 {

    static String nParam1 = "-#zE~F+Srl";

    static Object nParam2 = 0;

    static long nParam3 = -9223372036854775808L;

    static long nParam4 = 9223372036854775807L;

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object h = 0;

    static int count = -34480484;

    Notification handleNotification(Notification n, Object h) {
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11560().handleNotification(n, h);
    }
}
