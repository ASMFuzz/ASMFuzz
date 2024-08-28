import java.io.*;

public class MyJVMTest_6782 {

    static String fParam1Param1 = "</@)gO5$:_";

    static String fParam1Param2 = "(zBM1?UM%v";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "'>et!w:45~";

    static File f = new File(fParam1, fParam2);

    File checkHidden(File f) {
        if (!f.isHidden())
            throw new RuntimeException(f + " should be hidden");
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6782().checkHidden(f);
    }
}
