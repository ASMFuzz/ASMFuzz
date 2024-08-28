import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_14475 {

    static String label = "Nz}N H^vP\\";

    static Set<String> found = new HashSet<String>();

    static String expect = ".0o]DIKc  ";

    Set<String> checkCoverage(String label, Set<String> found, String... expect) throws Exception {
        Set<String> e = new TreeSet<String>(Arrays.asList(expect));
        if (!found.equals(e)) {
            e.removeAll(found);
            throw new Exception("expected " + label + " not used: " + e);
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14475().checkCoverage(label, found, expect);
    }
}
