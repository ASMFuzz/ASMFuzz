import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_17305 {

    static String propName = ";7je'+w]&Q";

    static Object propVal = 0;

    static DirContext ctx = null;

    Object addToEnvironment(String propName, Object propVal) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17305().addToEnvironment(propName, propVal));
    }
}
