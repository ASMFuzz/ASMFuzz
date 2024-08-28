import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_17217 {

    static Name name = null;

    static String[] attrIds = { ";ZNk%T'%Ly", "#j9oEQ_07!", "Mnm5:'#'.9", "tPnov-<L-H", "[sy(#|WQlU", "2be\"S4g6Qp", "[%rbfc5]@-", ",-BV|q7S0\"", "ILDhC;aN'+", "f`f*PlqG\\:" };

    static DirContext ctx = null;

    Attributes getAttributes(Name name, String[] attrIds) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17217().getAttributes(name, attrIds));
    }
}
