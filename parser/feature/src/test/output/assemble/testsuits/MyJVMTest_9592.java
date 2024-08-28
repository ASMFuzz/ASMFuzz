import java.util.*;
import java.io.*;
import java.util.logging.*;

public class MyJVMTest_9592 {

    static List<String> expNames = new ArrayList<String>();

    static List<String> retNames = new ArrayList<String>();

    static String failMsg = "?1Pzhm?J63";

    void printFailMsg(List<String> expNames, List<String> retNames, String failMsg) {
        out.println();
        out.println(failMsg);
        if (expNames.isEmpty()) {
            out.println("# there are NO expected logger names");
        } else {
            out.println("# expected logger names (" + expNames.size() + "):");
            for (int i = 0; i < expNames.size(); i++) {
                out.println(" expNames[" + i + "] = " + expNames.get(i));
            }
        }
        if (retNames.isEmpty()) {
            out.println("# there are NO returned logger names");
        } else {
            out.println("# returned logger names (" + retNames.size() + "):");
            for (int i = 0; i < retNames.size(); i++) {
                out.println("  retNames[" + i + "] = " + retNames.get(i));
            }
        }
    }

    static PrintStream out = System.out;

    static boolean PASSED = true;

    static boolean FAILED = false;

    boolean checkNames(List<String> expNames, List<String> retNames, String failMsg) {
        boolean status = PASSED;
        if (expNames.size() != retNames.size()) {
            status = FAILED;
        } else if (!new HashSet<>(expNames).equals(new HashSet<>(retNames))) {
            status = FAILED;
        }
        if (!status) {
            printFailMsg(expNames, retNames, failMsg);
        }
        return status;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9592().checkNames(expNames, retNames, failMsg));
    }
}
