import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.*;

public class MyJVMTest_7666 {

    static Name name = null;

    static String[] attrIds = { "|q]rxyBexk", "/',MK@-Z.{", "m.5r(O_-c#", "2E*~06]16~", "]ODy]2j0~'", "JnAX.HWf\"C", "aKFe2CWx]p", "7hht~Nw8V@", "Vs/PSr:%e`", "+#7(xYa\\{^" };

    static DirContext ctx = null;

    Attributes getAttributes(Name name, String[] attrIds) throws NamingException {
        throw new OperationNotSupportedException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7666().getAttributes(name, attrIds));
    }
}
