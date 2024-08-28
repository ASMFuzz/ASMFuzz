import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_16519 {

    static String state = "initial state";

    static int nbChanges = 0;

    static int nbResets = 0;

    void reset() {
        state = "initial state";
        nbChanges = 0;
        nbResets++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16519().reset();
    }
}
