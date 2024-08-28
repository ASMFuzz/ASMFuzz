import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.util.concurrent.*;

public class MyJVMTest_7072 {

    static String s = "qa2^BFFy>*";

    String dumpMemoryStats(String s) throws Exception {
        Runtime rt = Runtime.getRuntime();
        System.out.println(s + ":\t" + rt.freeMemory() + " bytes free");
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7072().dumpMemoryStats(s);
    }
}
