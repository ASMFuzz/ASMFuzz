import java.util.*;
import java.text.*;

public class MyJVMTest_14206 {

    static String parent = "8O9KBzu=~N";

    static String child = "BL3Y7W#3>~";

    static String patterninfo = "IDE+Q5%_XA";

    boolean contains(String parent, String child) {
        boolean result = false;
        if (parent.length() < child.length())
            result = false;
        else {
            for (int i = 0; i < parent.length() - child.length(); i++) {
                result = parent.regionMatches(i, child, 0, child.length());
                if (result == true)
                    break;
            }
        }
        return result;
    }

    boolean Test(String parent, String child, String patterninfo) {
        boolean result = true;
        if (!contains(parent, child)) {
            System.out.println("Full date: " + parent);
            System.out.println("Which should contain the day of the week: " + child);
            System.out.println("DateFormat.FULL don't contain pattern for the day of the week : " + patterninfo);
            result = false;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14206().Test(parent, child, patterninfo));
    }
}
