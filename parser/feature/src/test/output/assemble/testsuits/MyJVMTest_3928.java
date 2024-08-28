import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_3928 {

    static String name = ";',l>49'*H";

    static DirContext ctx = null;

    String destroySubcontext(String name) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3928().destroySubcontext(name);
    }
}
