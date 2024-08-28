import javax.security.auth.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;
import javax.security.auth.callback.*;
import java.util.*;

public class MyJVMTest_4363 {

    static boolean sParam1 = true;

    static Set<? extends Principal> sParam2 = new HashSet<? extends Principal>();

    static Set<?> sParam3 = new HashSet<?>();

    static Set<?> sParam4 = new HashSet<?>();

    static Subject s = new Subject(sParam1, sParam2, sParam3, sParam4);

    static CallbackHandler h = null;

    static Map<String, ?> ss = new HashMap<String, ?>();

    static Map<String, ?> options = new HashMap<String, ?>();

    Map<String, ?> initialize(Subject s, CallbackHandler h, Map<String, ?> ss, Map<String, ?> options) {
        throw new SecurityException("INITIALIZE");
        return options;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4363().initialize(s, h, ss, options);
    }
}
