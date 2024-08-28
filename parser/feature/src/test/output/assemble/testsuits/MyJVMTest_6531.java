import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_6531 {

    static String name = "rUU8\\qv&\"m";

    static ModificationItem[] mods = { null, null, null, null, null, null, null, null, null, null };

    static DirContext ctx = null;

    String modifyAttributes(String name, ModificationItem[] mods) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6531().modifyAttributes(name, mods);
    }
}
