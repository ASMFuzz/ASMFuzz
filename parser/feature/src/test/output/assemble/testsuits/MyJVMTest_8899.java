import static java.util.GregorianCalendar.*;

public class MyJVMTest_8899 {

    static String o1 = ",@kyJ(_,}G";

    static String o2 = "o]+YVf|i9:";

    int compare(String o1, String o2) {
        int n = o2.length() - o1.length();
        return (n == 0) ? o1.compareTo(o2) : n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8899().compare(o1, o2));
    }
}
