import java.util.*;

public class MyJVMTest_13422 {

    ClassLoaderType next() {
        return this.next;
    }

    static String id = "KWj(MS)<1i";

    static int ord = 877301635;

    static ClassLoaderType prev = null;

    static ClassLoaderType next = null;

    static int upperBound = 0;

    static ClassLoaderType first = null;

    static ClassLoaderType last = null;

    static ClassLoaderType curr = first;

    Object nextElement() {
        ClassLoaderType c = curr;
        curr = curr.next();
        return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13422().nextElement());
    }
}
