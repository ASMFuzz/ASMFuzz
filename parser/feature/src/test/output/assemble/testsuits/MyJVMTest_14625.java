import sun.misc.*;
import java.util.*;

public class MyJVMTest_14625 {

    static int n = 7;

    static int threadID = -1391273355, nObjects = 2;

    static Hashtable table = new Hashtable();

    Object doIt(int n) {
        Integer item = new Integer(n);
        return item;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14625().doIt(n));
    }
}
