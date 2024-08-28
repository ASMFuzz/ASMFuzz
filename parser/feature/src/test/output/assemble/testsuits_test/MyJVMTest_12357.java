import java.io.*;
import java.util.*;

public class MyJVMTest_12357 {

    static boolean unused = false;

    static Set<String> values = new HashSet<String>();

    static boolean listOfAny = false;

    static boolean setOfAny = false;

    void markUnused() {
        values = new LinkedHashSet<String>();
        values.add("unused");
        listOfAny = false;
        setOfAny = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12357().markUnused();
    }
}
