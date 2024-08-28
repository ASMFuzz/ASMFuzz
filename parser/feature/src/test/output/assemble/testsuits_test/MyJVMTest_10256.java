import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_10256 {

    static String fParam1 = "@2Dgm(w)+7";

    static String fParam2 = "%4IW`%Lw+G";

    static File f = new File(fParam1, fParam2);

    static File file = null;

    File other(File f) {
        return new File(f.getPath().toUpperCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10256().other(f));
    }
}
