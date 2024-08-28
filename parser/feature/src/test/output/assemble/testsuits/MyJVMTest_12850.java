import static java.util.GregorianCalendar.*;

public class MyJVMTest_12850 {

    static String o1 = "M,QY$|*jep";

    static String o2 = "!> ?.p\\7L1";

    int compare(String o1, String o2) {
        int n = o2.length() - o1.length();
        return (n == 0) ? o1.compareTo(o2) : n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12850().compare(o1, o2));
    }
}
