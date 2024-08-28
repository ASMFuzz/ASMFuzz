import java.io.*;
import sun.security.x509.*;
import sun.security.util.*;
import java.lang.reflect.*;

public class MyJVMTest_7491 {

    static Class avaClass = null;

    static Constructor avaCons = null;

    Object run() throws Exception {
        try {
            avaClass = Class.forName("sun.security.x509.AVA");
            Constructor[] cons = avaClass.getDeclaredConstructors();
            int i;
            for (i = 0; i < cons.length; i++) {
                Class[] parms = cons[i].getParameterTypes();
                if (parms.length == 2) {
                    if (parms[0].getName().equalsIgnoreCase("sun.security.util.ObjectIdentifier") && parms[1].getName().equalsIgnoreCase("sun.security.util.DerValue")) {
                        avaCons = cons[i];
                        avaCons.setAccessible(true);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Caught unexpected exception " + e);
            throw e;
        }
        return avaCons;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7491().run());
    }
}
