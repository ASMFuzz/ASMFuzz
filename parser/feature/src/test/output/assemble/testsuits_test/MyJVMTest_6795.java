import java.util.*;

public class MyJVMTest_6795 {

    ClassLoaderType next() {
        return this.next;
    }

    static String id = "T@%*'JaUdR";

    static int ord = 3;

    static ClassLoaderType prev = null;

    static ClassLoaderType next = null;

    static int upperBound = 0;

    static ClassLoaderType first = null;

    static ClassLoaderType last = null;

    static ClassLoaderType curr = first;

    Enumeration elements() {
        return new Enumeration() {

            ClassLoaderType curr = first;

            public boolean hasMoreElements() {
                return curr != null;
            }

            public Object nextElement() {
                ClassLoaderType c = curr;
                curr = curr.next();
                return c;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6795().nextElement());
    }
}
