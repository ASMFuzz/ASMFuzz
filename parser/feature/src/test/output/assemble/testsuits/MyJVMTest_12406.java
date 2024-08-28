import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_12406 {

    static java.util.List errors = new java.util.LinkedList();

    boolean report() {
        if (errors.size() != 0) {
            System.err.println("Test FAILED");
        } else {
            System.err.println("Test PASSED");
            return true;
        }
        ListIterator iter = errors.listIterator();
        while (iter.hasNext()) {
            System.err.println(iter.next());
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12406().report());
    }
}
