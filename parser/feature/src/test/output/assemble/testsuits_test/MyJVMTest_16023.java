import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_16023 {

    static String name = "UA>gum4oRq";

    static ModificationItem[] mods = { null, null, null, null, null, null, null, null, null, null };

    static DirContext ctx = null;

    String modifyAttributes(String name, ModificationItem[] mods) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16023().modifyAttributes(name, mods);
    }
}
