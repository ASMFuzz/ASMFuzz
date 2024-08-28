import javax.naming.ldap.*;
import java.util.ArrayList;

public class MyJVMTest_10600 {

    static String name1Param1 = "95cENUv%O{";

    static LdapName name1 = new LdapName(name1Param1);

    static List<Rdn> name2Param1 = new ArrayList<Rdn>();

    static LdapName name2 = new LdapName(name2Param1);

    static int expectedResult = 7;

    boolean isPositive(int n) {
        return (n >= 0) ? true : false;
    }

    LdapName checkResults(LdapName name1, LdapName name2, int expectedResult) throws Exception {
        System.out.println("Checking name1: " + name1 + " and name2: " + name2);
        boolean isEquals = (expectedResult == 0) ? true : false;
        int result = name1.compareTo(name2);
        if ((isEquals && (result != expectedResult)) || isPositive(result) != isPositive(expectedResult)) {
            throw new Exception("Comparison test failed for name1:" + name1 + " name2:" + name2 + ", expected (1 => positive, -1 => negetive): " + expectedResult + " but got: " + result);
        }
        if (name1.equals(name2) != isEquals) {
            throw new Exception("Equality test failed for name1: " + name1 + " name2:" + name2 + ", expected: " + isEquals);
        }
        if (isEquals && (name1.hashCode() != name2.hashCode())) {
            System.out.println("name1.hashCode(): " + name1.hashCode() + " name2.hashCode(): " + name2.hashCode());
            throw new Exception("hashCode test failed for name1:" + name1 + " name2:" + name2);
        }
        return name1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10600().checkResults(name1, name2, expectedResult);
    }
}
