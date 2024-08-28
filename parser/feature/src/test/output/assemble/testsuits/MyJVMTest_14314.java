import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_14314 {

    NetworkInterface getNextIf() {
        if (ifs != null) {
            while (ifs.hasMoreElements()) {
                NetworkInterface nic = (NetworkInterface) ifs.nextElement();
                if (isWindows) {
                    String dName = nic.getDisplayName();
                    if (dName != null && dName.contains("Teredo"))
                        continue;
                } else if (isMacOS && nic.getName().contains("awdl")) {
                    continue;
                }
                try {
                    if (nic.isUp() && !nic.isLoopback())
                        return nic;
                } catch (SocketException e) {
                }
            }
        }
        return null;
    }

    boolean hasMoreElements() {
        if (nextAddr == null) {
            nextAddr = getNext();
        }
        return (nextAddr != null);
    }

    Object nextElement() {
        if (!hasMoreElements()) {
            throw new NoSuchElementException("no more addresses");
        }
        Object next = nextAddr;
        nextAddr = null;
        return next;
    }

    static boolean isWindows = System.getProperty("os.name").startsWith("Windows");

    static boolean isMacOS = System.getProperty("os.name").contains("OS X");

    static Enumeration ifs = null;

    static NetworkInterface currIf = null;

    static InetAddress nextAddr = null;

    static Enumeration addrs = null;

    static Class filter = null;

    static byte[] fe80_loopback = new byte[] { (byte) 0xfe, (byte) 0x80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };

    static Runnable runnee = null;

    static long delay = -9223372036854775808L;

    static String osname = "G8.i\\fl0W5";

    InetAddress getNext() {
        while (true) {
            if (currIf == null) {
                currIf = getNextIf();
                if (currIf == null) {
                    return null;
                }
                addrs = currIf.getInetAddresses();
            }
            while (addrs.hasMoreElements()) {
                InetAddress addr = (InetAddress) addrs.nextElement();
                if (filter.isInstance(addr) && !addr.isLoopbackAddress() && !addr.isAnyLocalAddress()) {
                    if (Arrays.equals(addr.getAddress(), fe80_loopback)) {
                        continue;
                    }
                    return addr;
                }
            }
            currIf = null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14314().getNext());
    }
}
