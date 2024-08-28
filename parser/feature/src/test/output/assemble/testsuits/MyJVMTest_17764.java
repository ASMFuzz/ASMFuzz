import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_17764 {

    static String name = "3L/$p<K+hf";

    static DirContext ctx = null;

    NamingEnumeration<NameClassPair> list(String name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17764().list(name));
    }
}
