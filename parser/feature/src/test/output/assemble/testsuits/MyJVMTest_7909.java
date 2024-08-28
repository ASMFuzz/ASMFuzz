import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_7909 {

    static String name = "vrk8,ypV3p";

    static Object obj = 5;

    static DirContext ctx = null;

    String bind(String name, Object obj) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7909().bind(name, obj);
    }
}
