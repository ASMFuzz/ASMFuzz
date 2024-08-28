import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_5552 {

    static Name name = null;

    static ModificationItem[] mods = { null, null, null, null, null, null, null, null, null, null };

    static DirContext ctx = null;

    Name modifyAttributes(Name name, ModificationItem[] mods) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5552().modifyAttributes(name, mods);
    }
}
