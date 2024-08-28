import java.io.*;

public class MyJVMTest_3587 {

    static String fParam1Param1Param1 = "BEK\\-YV(?w";

    static File fParam1Param1 = new File(fParam1Param1Param1);

    static String fParam1Param2 = "Xwu>NW7glR";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "t:aD{DI!Bh";

    static File f = new File(fParam1, fParam2);

    boolean accept(File f) {
        return f.getPath().endsWith(".class");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3587().accept(f));
    }
}
