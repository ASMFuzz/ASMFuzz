import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.rmi.server.*;
import java.util.*;
import javax.management.*;
import javax.management.remote.*;
import javax.management.remote.rmi.*;

public class MyJVMTest_2300 {

    static String nParam1 = "0z2tPJevu_";

    static Object nParam2 = 1;

    static long nParam3 = 9223372036854775807L;

    static Notification n = new Notification(nParam1, nParam2, nParam3);

    static Object h = 1170788496;

    static int count = 0;

    Notification handleNotification(Notification n, Object h) {
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2300().handleNotification(n, h);
    }
}
