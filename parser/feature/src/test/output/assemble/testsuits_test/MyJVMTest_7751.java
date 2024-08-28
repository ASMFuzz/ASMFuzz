import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_7751 {

    static String propName = "d]x3@rY}i{";

    static Object propVal = 455946792;

    static DirContext ctx = null;

    Object addToEnvironment(String propName, Object propVal) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7751().addToEnvironment(propName, propVal));
    }
}
