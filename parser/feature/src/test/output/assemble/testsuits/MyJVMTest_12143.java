import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_12143 {

    static String fParam1Param1Param1 = " &~d`gi2B0";

    static File fParam1Param1 = new File(fParam1Param1Param1);

    static String fParam1Param2 = "Ca;89[NEk=";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "\"d0,%u@l&|";

    static File f = new File(fParam1, fParam2);

    static File file = null;

    File other(File f) {
        return f.getAbsoluteFile();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12143().other(f));
    }
}
