import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_9453 {

    static Name name = null;

    static DirContext ctx = null;

    Context createSubcontext(Name name) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9453().createSubcontext(name));
    }
}
