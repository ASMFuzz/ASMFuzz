import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.rmi.server.*;
import java.util.*;
import javax.management.*;
import javax.management.remote.*;
import javax.management.remote.rmi.*;

public class MyJVMTest_14460 {

    void close() throws IOException {
        ss.close();
    }

    static ServerSocket ss = null;

    static List sList = new ArrayList();

    static boolean broken = false;

    boolean setBroken(boolean broken) {
        this.broken = broken;
        if (!broken)
            return;
        for (Iterator it = sList.iterator(); it.hasNext(); ) {
            Socket s = (Socket) it.next();
            try {
                s.close();
            } catch (IOException e) {
                System.out.println("Unable to close socket: " + s + ", ignoring (" + e + ")");
            }
            it.remove();
        }
        return broken;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14460().setBroken(broken);
    }
}
