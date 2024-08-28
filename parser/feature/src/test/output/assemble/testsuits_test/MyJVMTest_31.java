import java.util.*;
import java.text.*;

public class MyJVMTest_31 {

    static String parent = "\"0}@]nh{A;";

    static String child = "?yw.U;3fEJ";

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_31().contains(parent, child));
    }
}
