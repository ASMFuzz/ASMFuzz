import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_4119 {

    static DirContext ctx = null;

    Hashtable getEnvironment() throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4119().getEnvironment());
    }
}
