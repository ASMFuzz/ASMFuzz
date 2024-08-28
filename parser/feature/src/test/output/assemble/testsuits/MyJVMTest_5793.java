import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_5793 {

    static String s = ";?*_=W;Gge";

    static String state = "initial state";

    static int nbChanges = 0;

    String setState(String s) {
        state = s;
        nbChanges++;
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5793().setState(s);
    }
}
