import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_15919 {

    static String name = "zKO[2-X!Un";

    static String[] attrIds = { "S,joaFQJW,", "jUj6.Z_H=;", "))0hc-w1Tz", "u2QF\\#}@+T", "%Cue&](]vv", "KH?~`?Tkq<", "4_'$!)~)Ej", "v2UCGj.zB3", "6HT(pu}T~:", "^SF&Zb]rH\"" };

    static DirContext ctx = null;

    Attributes getAttributes(String name, String[] attrIds) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15919().getAttributes(name, attrIds));
    }
}
