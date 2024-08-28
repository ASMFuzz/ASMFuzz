import java.io.*;
import sun.security.util.*;
import sun.security.x509.*;
import java.lang.reflect.*;

public class MyJVMTest_7698 {

    static Class dibClass = null;

    static Constructor dibCons = null;

    Object run() throws Exception {
        try {
            dibClass = Class.forName("sun.security.util.DerInputBuffer");
            Constructor[] cons = dibClass.getDeclaredConstructors();
            int i;
            for (i = 0; i < cons.length; i++) {
                Class[] parms = cons[i].getParameterTypes();
                if (parms.length == 1) {
                    if (parms[0].getName().equalsIgnoreCase("[B")) {
                        cons[i].setAccessible(true);
                        break;
                    }
                }
            }
            dibCons = cons[i];
        } catch (Exception e) {
            System.out.println("Caught unexpected exception " + e);
            throw e;
        }
        return dibCons;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7698().run());
    }
}
