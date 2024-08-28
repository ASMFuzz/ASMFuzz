import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_4357 {

    static String name = "s!P~X}]:Wb";

    static DirContext ctx = null;

    String unbind(String name) throws NamingException {
        throw new OperationNotSupportedException();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4357().unbind(name);
    }
}
