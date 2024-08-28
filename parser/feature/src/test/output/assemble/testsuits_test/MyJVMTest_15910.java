import java.io.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_15910 {

    static String name = "uJ50Tqpto(";

    static String locParam1 = "]c2O+F!|\"4";

    static String locParam2 = "^D!;fYOrRA";

    static Locale loc = new Locale(locParam1, locParam2);

    List<Locale> getCandidateLocales(String name, Locale loc) {
        return Arrays.asList(Locale.US, null, Locale.ENGLISH);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15910().getCandidateLocales(name, loc));
    }
}
