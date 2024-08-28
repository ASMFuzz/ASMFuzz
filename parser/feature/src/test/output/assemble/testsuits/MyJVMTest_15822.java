import java.util.*;
import java.io.*;
import java.util.logging.*;

public class MyJVMTest_15822 {

    static List<String> expNames = new ArrayList<String>();

    static List<String> retNames = new ArrayList<String>();

    static String failMsg = ",`jyRd,tgL";

    static PrintStream out = System.out;

    List<String> printFailMsg(List<String> expNames, List<String> retNames, String failMsg) {
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
        return retNames;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15822().printFailMsg(expNames, retNames, failMsg);
    }
}
